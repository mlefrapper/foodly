package com.mlefrapper.foodly.ui.screen.main.scan

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import com.mlefrapper.foodly.ui.theme.FoodlyTheme
import timber.log.Timber

@Composable
fun ScanScreen(viewModel: ScanViewModel = viewModel()) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    var barCodeState by remember {
        mutableStateOf("")
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                // Permission Accepted
            } else {
                // Permission Denied
            }
        },
    )

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                // Check camera permission
                when (PackageManager.PERMISSION_GRANTED) {
                    ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.CAMERA,
                    ),
                    -> {
                        // Permission is granted
                        Timber.d("Camera permission is already granted")
                    }
                    else -> {
                        // Permission is not granted, request it
                        launcher.launch(Manifest.permission.CAMERA)
                    }
                }
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        // When the effect leaves the Composition, remove the observer
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    val barcodeScanner = BarcodeScanning.getClient()

    var scannedCode by remember { mutableStateOf("") }

    val scanLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview(),
        onResult = { imageBitmap ->
            if (imageBitmap != null) {
                val image = InputImage.fromBitmap(imageBitmap, 0)
                barcodeScanner.process(image)
                    .addOnSuccessListener { barcodes ->
                        for (barcode in barcodes) {
                            scannedCode = barcode.rawValue ?: ""
                            barCodeState = scannedCode
                            viewModel.search(scannedCode)
                            break // Process only the first barcode
                        }
                    }
                    .addOnFailureListener { exception ->
                        Timber.e("Barcode scanning failed", exception)
                    }
            }
        },
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = {
                scanLauncher.launch(null)
            },
        ) {
            Text("Scan Barcode")
        }
        Text("Scanned Code: $scannedCode")
    }
}

@Preview(showBackground = true)
@Composable
fun ScanScreenPreview() {
    FoodlyTheme {
        ScanScreen(
            viewModel = ScanViewModel(),
        )
    }
}
