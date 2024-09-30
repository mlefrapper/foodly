package com.mlefrapper.foodly.ui.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.mlefrapper.foodly.ui.theme.FoodlyTheme

class CustomRoundedShape(
    private val cornerRadius: Dp,
    private val circleRadius: Dp,
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        return Outline.Generic(createPath(size, density))
    }

    private fun createPath(size: Size, density: Density): Path {
        val cornerRadiusPx = with(density) {
            cornerRadius.toPx()
        }
        val circleRadiusPx = with(density) {
            circleRadius.toPx()
        }

        val topCornerRadius = CornerRadius(cornerRadiusPx)
        val bottomCornerRadius = CornerRadius(
            x = 0f,
            y = 0f,
        )
        return Path().apply {
            addRoundRect(
                RoundRect(
                    left = 0f,
                    top = 0f,
                    right = size.width,
                    bottom = size.height,
                    topLeftCornerRadius = topCornerRadius,
                    topRightCornerRadius = topCornerRadius,
                    bottomLeftCornerRadius = bottomCornerRadius,
                    bottomRightCornerRadius = bottomCornerRadius,
                ),
            )
            addOval(
                Rect(
                    Offset(
                        x = size.width / 2,
                        y = 0f,
                    ),
                    circleRadiusPx,
                ),
            )
            fillType = PathFillType.EvenOdd
        }
    }
}

@Composable
fun CustomShapeBox() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(
                color = Color.White,
                shape = CustomRoundedShape(
                    cornerRadius = 16.dp,
                    circleRadius = 30.dp,
                ),
            ),
    )
}

@Preview(showBackground = false)
@Composable
fun CustomShapeBoxPreview() {
    FoodlyTheme {
        CustomShapeBox()
    }
}
