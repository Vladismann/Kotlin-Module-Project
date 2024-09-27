package data

data class Archive(override val name: String) : Entity(name) {
    override fun toString(): String {
        return name
    }
}