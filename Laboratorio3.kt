// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(10, "Enero", null, true))
    print(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    var OriginalPos: Int
    var contador: Int = 0

    var lista: MutableList<ItemData>? = mutableListOf()

    if (inputList == null){
        return null
    }

    inputList?.forEach{
        OriginalPos = contador
        contador += 1
        when (it) {
            is String -> {lista?.add(ItemData(
                originalPos = OriginalPos,
                originalValue = it,
                type = "cadena",
                info = "L"+(it).length
            ))}
            is Int -> {lista?.add(ItemData(
                originalPos = OriginalPos,
                originalValue = it,
                type = "entero",
                info = typeInt(it)
            ))}
            is Boolean -> {lista?.add(ItemData(
                originalPos = OriginalPos,
                originalValue = it,
                type = "booleano",
                info = if ((it) == true) "Verdadero" else "Falso"
            ))}
            null -> {}
            else -> {lista?.add(ItemData(OriginalPos, it))}
        }
    }
    return lista

}


fun typeInt(item: Int): String?{
    var Info: String = ""
    if ((item % 10) == 0){
        Info = "m10"
    }
    else if ((item % 5) == 0){
        Info = "m5"
    }
    else if ((item % 2) == 0){
        Info = "m2"
    }
    else {
        return null
    }
    return Info
}