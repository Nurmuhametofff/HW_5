open class CRUDservice<E: Node> {
    val elements = mutableListOf<E>()
    private var nextId = 1

    fun add(elem: E): E{
        elem.id = nextId++
        elements.add(elem)
        return elements.last()
    }
    fun getById(id: Int): E?{
        return elements.find { it.id == id }
    }
    fun update(elem: E): Boolean{
        for ((index, node) in elements.withIndex()){
            if(node.id == elem.id){
                elements[index] = elem
                return true
            }
        }
        return false
    }


}

open class Node(var id: Int)