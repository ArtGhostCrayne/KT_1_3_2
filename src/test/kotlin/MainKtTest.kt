import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calcFee_VK_noFee() {
        val payType = VK
        val sumPerMonth = 0
        val amount = 1000
        val result = calcFee(
            payType = payType,
            sumPerMonth = sumPerMonth,
            amount = amount
        )
        assertEquals(0, result)
    }

    @Test
    fun calcFee_MastercardMaestro_withFee() {
        val payType = MASTERCARD
        val sumPerMonth = 70000
        val amount = 3000
        val result = calcFee(
            payType = payType,
            sumPerMonth = sumPerMonth,
            amount = amount
        )
        assertEquals(1800, result)
    }

    @Test
    fun calcFee_MastercardMaestro_withoutFee() {
        val payType = MAESTRO
        val sumPerMonth = 75000
        val amount = 3000
        val result = calcFee(
            payType = payType,
            sumPerMonth = sumPerMonth,
            amount = amount
        )
        assertEquals(0, result)
    }

    @Test
    fun calcFee_MIRVisa() {
        val payType = MIR
        val sumPerMonth = 70000
        val amount = 3000
        val result = calcFee(
            payType = payType,
            sumPerMonth = sumPerMonth,
            amount = amount
        )
        assertEquals(2250, result)
    }

    @Test
    fun calcFee_WrongCard() {
        val payType = "KIWI"
        val sumPerMonth = 70000
        val amount = 3000
        val result = calcFee(
            payType = payType,
            sumPerMonth = sumPerMonth,
            amount = amount
        )
        assertEquals(-1, result)
    }


}