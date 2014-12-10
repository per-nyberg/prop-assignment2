(defmacro safe ([][]))      ; macro


;Pseudo code

try (Socket s = new Socket()
arg = println("123");

macro(vector[s,new Socket()],arg){
	if(safe){ ;how to check if safe?
		close s
		return arg ;call arg and print "123"
	}else if (){   ;if arg wasn't correct
		close s
		return exception 
	}
}
