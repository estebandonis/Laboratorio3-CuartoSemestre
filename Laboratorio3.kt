// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
	var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
        val result = processList(listOf(20, 25, 2, 7, "hola", "", true, false, null, 2.0))
        println(result)
    }

fun processList(inputList: List<Any?>?): List<ItemData>? {
    var contador: Int = 0
    var lista: MutableList<ItemData>? = mutableListOf()
    if (inputList == null) return null
    inputList?.forEach{
        when (it) {
            is String -> {lista?.add(ItemData(originalPos = contador, originalValue = it, type = "cadena", info = "l"+(it).length))}
            is Int -> {lista?.add(ItemData(originalPos = contador, originalValue = it, type = "entero", info = typeInt(it)))}
            is Boolean -> {lista?.add(ItemData(originalPos = contador, originalValue = it, type = "booleano",info = if ((it) == true) "verdadero" else "falso"))}
            null -> {}
            else -> {lista?.add(ItemData(contador, it))}
        }
        contador += 1
    }
    return lista
}
fun typeInt(item: Int): String?{
    val Info: String = if ((item % 10) == 0) "m10" else if ((item % 5) == 0) "m5" else if ((item % 2) == 0) "m2" else return null
    return Info
}