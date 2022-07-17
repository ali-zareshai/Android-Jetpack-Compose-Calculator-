package ir.wave.composecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.wave.composecalculator.Utils.*


@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    calculatorColors: CalculatorColors = CalculatorColors(
        operatorBgColor = MaterialTheme.colorScheme.secondaryContainer,
        operatorColor = MaterialTheme.colorScheme.onSecondaryContainer,
        numberBgColor = MaterialTheme.colorScheme.surfaceVariant,
        numberColor = MaterialTheme.colorScheme.onSurfaceVariant,
        evalBgColor = MaterialTheme.colorScheme.primaryContainer,
        evalColor = MaterialTheme.colorScheme.onPrimaryContainer,
        acBgColor = MaterialTheme.colorScheme.tertiaryContainer,
        acColor = MaterialTheme.colorScheme.onTertiaryContainer,
        backgroundColor = MaterialTheme.colorScheme.background,
        mainTextBgColor = MaterialTheme.colorScheme.surfaceVariant,
        mainTextColor = MaterialTheme.colorScheme.onSurfaceVariant
    ),
    onResult: (String) -> Unit = {}
) {

    val viewModel = viewModel<CalculatorViewModel>()
    viewModel.onResult = onResult
    val onAction = viewModel::onAction
    val state = viewModel.state
    val buttonSpacing = 8.dp


    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val maxH: Dp = screenHeight * 3 / 5
    Box(
        modifier = modifier
            .background(calculatorColors.backgroundColor)
            .wrapContentSize()
    ) {

        Column(
            modifier = Modifier
                .widthIn(50.dp, maxH)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth()
                    .background(
                        calculatorColors.mainTextBgColor,
                        RoundedCornerShape(0.dp, 0.dp, 12.dp, 12.dp)
                    )
                    .padding(24.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Light,
                    lineHeight = 50.sp,
                    fontSize = 50.sp,
                    maxLines = 3,
                    color = calculatorColors.mainTextColor
                )
            }
            Column(
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxWidth()
                    .padding(buttonSpacing),
                verticalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Row(
                    modifier = Modifier
                        .weight(0.2f),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "AC",
                        modifier = Modifier
                            .background(calculatorColors.acBgColor)
                            .aspectRatio(2f)
                            .weight(2f),

                        onClick = {
                            onAction(CalculatorAction.Clear)
                        }, color = calculatorColors.acColor
                    )
                    /*CalculatorButton(
                        symbol = "( )",
                        modifier = Modifier
                            .background(LightBlue)
                            .aspectRatio(1f)
                            .weight(1f),

                        onClick = {
                            // TODO
                        }
                    )*/
                    CalculatorButton(
                        symbol = "%",
                        modifier = Modifier
                            .background(calculatorColors.operatorBgColor)
                            .aspectRatio(1f)
                            .weight(1f),

                        onClick = {
//                        onAction(CalculatorAction.Operation(CalculatorOperation.Modulo))
                            onAction(CalculatorAction.Number('%'))
                        },
                        color = calculatorColors.operatorColor
                    )
                    CalculatorButton(
                        symbol = "/",
                        modifier = Modifier
                            .background(calculatorColors.operatorBgColor)
                            .aspectRatio(1f)
                            .weight(1f),

                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                        },
                        color = calculatorColors.operatorColor
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "7",
                        modifier = Modifier
                            .background(calculatorColors.numberBgColor)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number('7'))
                        },
                        color = calculatorColors.numberColor
                    )
                    CalculatorButton(
                        symbol = "8",
                        modifier = Modifier
                            .background(calculatorColors.numberBgColor)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number('8'))
                        },
                        color = calculatorColors.numberColor
                    )
                    CalculatorButton(
                        symbol = "9",
                        modifier = Modifier
                            .background(calculatorColors.numberBgColor)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number('9'))
                        },
                        color = calculatorColors.numberColor
                    )
                    CalculatorButton(
                        symbol = "×",
                        modifier = Modifier
                            .background(calculatorColors.operatorBgColor)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                        },
                        color = calculatorColors.operatorColor
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "4",
                        modifier = Modifier
                            .background(calculatorColors.numberBgColor)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number('4'))
                        },
                        color = calculatorColors.numberColor
                    )
                    CalculatorButton(
                        symbol = "5",
                        modifier = Modifier
                            .background(calculatorColors.numberBgColor)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number('5'))
                        },
                        color = calculatorColors.numberColor
                    )
                    CalculatorButton(
                        symbol = "6",
                        modifier = Modifier
                            .background(calculatorColors.numberBgColor)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number('6'))
                        },
                        color = calculatorColors.numberColor
                    )
                    CalculatorButton(
                        symbol = "-",
                        modifier = Modifier
                            .background(calculatorColors.operatorBgColor)
                            .aspectRatio(1f)
                            .weight(1f),

                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                        },
                        color = calculatorColors.operatorColor
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "1",
                        modifier = Modifier
                            .background(calculatorColors.numberBgColor)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number('1'))
                        },
                        color = calculatorColors.numberColor
                    )
                    CalculatorButton(
                        symbol = "2",
                        modifier = Modifier
                            .background(calculatorColors.numberBgColor)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number('2'))
                        },
                        color = calculatorColors.numberColor
                    )
                    CalculatorButton(
                        symbol = "3",
                        modifier = Modifier
                            .background(calculatorColors.numberBgColor)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number('3'))
                        },
                        color = calculatorColors.numberColor
                    )
                    CalculatorButton(
                        symbol = "+",
                        modifier = Modifier
                            .background(calculatorColors.operatorBgColor)
                            .aspectRatio(1f)
                            .weight(1f),

                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                        },
                        color = calculatorColors.operatorColor
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "0",
                        modifier = Modifier
                            .background(calculatorColors.numberBgColor)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number('0'))
                        },
                        color = calculatorColors.numberColor
                    )
                    CalculatorButton(
                        symbol = ".",
                        modifier = Modifier
                            .background(calculatorColors.numberBgColor)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Decimal)
                        },
                        color = calculatorColors.numberColor
                    )
                    PainterCalculatorButton(
                        symbol = painterResource(id = R.drawable.ic_backspace_outlined),
                        modifier = Modifier
                            .background(calculatorColors.numberBgColor)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Delete)
                        },
                        color = calculatorColors.numberColor
                    )
                    CalculatorButton(
                        symbol = "=",
                        modifier = Modifier
                            .background(calculatorColors.evalBgColor)
                            .aspectRatio(1f)
                            .weight(1f),

                        onClick = {
                            onAction(CalculatorAction.Calculate)
                        },
                        color = calculatorColors.evalColor
                    )
                }


            }
        }
    }



    @Composable
    fun CalculatorColors() {

    }
}

