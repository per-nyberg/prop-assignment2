

(defmacro safe ([][]))

;Pseudo code

try (Socket s = new Socket()
arg = println("123");

macro(vector[s,new Socket()],arg){
	if(arg == safe){ ;how to check if safe?
		close s
		return arg ;call arg and print "123"
	}else if(arg caused exception){
		close s
		return exception
	}
}
