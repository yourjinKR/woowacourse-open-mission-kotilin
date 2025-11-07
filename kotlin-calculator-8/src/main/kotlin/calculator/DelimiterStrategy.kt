package calculator

interface DelimiterStrategy {
    fun isSupport(rawData: String): Boolean
    fun getCalcArea(rawData: String): List<String>
}