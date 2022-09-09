const val MIR = "Mir"
const val VK = "Vkpay"
const val MASTERCARD = "Mastercard"
const val MAESTRO = "Maestro"
const val VISA = "Visa"


fun main() {

    val payType = MIR
    val sumPerMonth = 70000
    val amount = 3000

    val fee = calcFee(payType = payType, sumPerMonth = sumPerMonth, amount = amount)
    if (fee != -1) {
        println("Перевод $amount руб. комиссия $fee коп.")
    } else
        println("Перевод не возможен")

}

fun calcFee(payType: String, sumPerMonth: Int, amount: Int): Int {

    return when (payType) {
        VK -> 0
        MASTERCARD, MAESTRO -> if (sumPerMonth < 75000) {
            ((amount * 100) / 100 * 0.6).toInt()
        } else {
            0
        }
        MIR, VISA -> ((amount * 100) / 100 * 0.75).toInt()
        else -> -1
    }
}