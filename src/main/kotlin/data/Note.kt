package data

data class Note(override val name: String, val archiveName: String, val text: String) : Entity(name)
