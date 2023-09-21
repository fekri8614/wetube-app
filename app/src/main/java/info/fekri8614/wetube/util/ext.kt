package info.fekri8614.wetube.util

// extra functions and etc.

fun textLengthStyle(txt: String, length: Int): String {
    if (txt.length > length) return txt.substring(0, length) + "..."
    return txt
}
