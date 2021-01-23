import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calcVisaMirBigAmount() {
        //Arrange
        val monthAmount = 0
        val amount = 10_000_000
        val expectedResult = 74_000
        //Act
        val result = calcVisaMir(
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcVisaMirSmallAmount() {
        //Arrange
        val monthAmount = 100
        val amount = 100_000
        val expectedResult = 3_500
        //Act
        val result = calcVisaMir(
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcVisaMirInvalidMonthLimit() {
        //Arrange
        val monthAmount = 60_000_100
        val amount = 10
        val expectedResult = -1
        //Act
        val result = calcVisaMir(
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcVisaMirInvalidDayLimit() {
        //Arrange
        val monthAmount = 1_000
        val amount = 15_000_100
        val expectedResult = -1
        //Act
        val result = calcVisaMir(
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcMasterMaestroMoreThanOnceDayLimit() {
        //Arrange
        val monthAmount = 0
        val amount = 7_600_000
        val expectedResult = 47_600
        //Act
        val result = calcMasterMaestro(
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcMasterMaestroLessThanOnceDayLimit() {
        //Arrange
        val monthAmount = 0
        val amount = 7_499_999
        val expectedResult = 0
        //Act
        val result = calcMasterMaestro(
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcMasterMaestroInvalidMonthLimit() {
        //Arrange
        val monthAmount = 60_000_100
        val amount = 0
        val expectedResult = -1
        //Act
        val result = calcMasterMaestro(
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcMasterMaestroInvalidDayLimit() {
        //Arrange
        val monthAmount = 0
        val amount = 15_000_100
        val expectedResult = -1
        //Act
        val result = calcMasterMaestro(
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcVKPayAmount() {
        //Arrange
        val monthAmount = 0
        val amount = 100_000
        val expectedResult = 0
        //Act
        val result = calcVkPay(
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcVKPayInvalidMonthLimit() {
        //Arrange
        val monthAmount = 4_000_100
        val amount = 0
        val expectedResult = -1
        //Act
        val result = calcVkPay(
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcVKPayInvalidDayLimit() {
        //Arrange
        val monthAmount = 0
        val amount = 1_500_100
        val expectedResult = -1
        //Act
        val result = calcVkPay(
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcFeeVisa() {
        //Arrange
        val nameCardAccount = "Visa"
        val monthAmount = 0
        val amount = 1_500_100
        val expectedResult = 11_250
        //Act
        val result = calcFee(
                nameCardAccount = nameCardAccount,
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcFeeMIR() {
        //Arrange
        val nameCardAccount = "MIR"
        val monthAmount = 0
        val amount = 1_500_100
        val expectedResult = 11_250
        //Act
        val result = calcFee(
                nameCardAccount = nameCardAccount,
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcFeeMasterCard() {
        //Arrange
        val nameCardAccount = "MasterCard"
        val monthAmount = 0
        val amount = 1_500_100
        val expectedResult = 0
        //Act
        val result = calcFee(
                nameCardAccount = nameCardAccount,
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcFeeMaestro() {
        //Arrange
        val nameCardAccount = "Maestro"
        val monthAmount = 0
        val amount = 1_500_100
        val expectedResult = 0
        //Act
        val result = calcFee(
                nameCardAccount = nameCardAccount,
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcFeeVKPay() {
        //Arrange
        val nameCardAccount = "VKPay"
        val monthAmount = 0
        val amount = 1_400_000
        val expectedResult = 0
        //Act
        val result = calcFee(
                nameCardAccount = nameCardAccount,
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun calcFeeWrongNameCardAccount() {
        //Arrange
        val nameCardAccount = "WrongNameCardAccount"
        val monthAmount = 0
        val amount = 1_400_000
        val expectedResult = -2
        //Act
        val result = calcFee(
                nameCardAccount = nameCardAccount,
                monthAmount = monthAmount,
                amount = amount,
        )
        //Assert
        assertEquals(expectedResult, result.toInt())
    }

    @Test
    fun outputPrintResultsExceedingLimit() {
        //Arrange
        val fee = -1
        val expectedResult = println("\n\t\tОперация невозможна. \nПричина - превышение лимита (дневного и/или месячного). " +
                "\nПопробуйте уменьшить сумму транзакции.")
        //Act
        val result = printResults(
                fee = fee,
        )
        //Assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun outputPrintResultsInvalidCardAccount() {
        //Arrange
        val fee = -2
        val expectedResult = println("\n\tОперация невозможна - указана неверная карта или счет.")
        //Act
        val result = printResults(
                fee = fee,
        )
        //Assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun outputPrintResultsCorrectionFee() {
        //Arrange
        val fee = 30_000
        val expectedResult = println("\n\tКомиссия к оплате: ${fee / 100}руб. ${fee % 100}коп.")
        //Act
        val result = printResults(
                fee = fee,
        )
        //Assert
        assertEquals(expectedResult, result)
    }
}