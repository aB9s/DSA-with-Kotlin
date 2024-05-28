class <T> StackData(val size: Int){
	
	private var top: Int = -1
	private val stackArray: Array<T?> = arrayOfNulls<Any>(size) as Array<T?>


	fun push(value: T): Boolean{
		if(isFull()){
			println("Stack is full.")
			return false
		} else{
			stackArray[++top] = value
			return true
		}
	}

	fun pop(): T?{
		if(isEmpty()){
			println("Stack is empty.")
			return null
		} else{
			return stackArray[top--]
		}

	}

	fun isEmpty(): Boolean = top<0

	fun isFull(): Boolean = top == size-1

}