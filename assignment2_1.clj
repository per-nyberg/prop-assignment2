; ASSIGNMENT 2 Safe macro
;
;You should define a macro 'safe' with two arguments. The first argument should be a vector with two
;elements, one variable and one value (corresponding to 's' and 'new Socket()' in the example above).
;The second argument should be a form (expression) that should be evaluated. The macro 'safe'
;should either return the return value of the second argument or an exception. In both cases the
;variable should be closed (if it is an instance of java.io.Closeable; hint use 'instance?'). It should be
;possible to use the variable inside the form (expression) as in the following example:
;=> (import java.io.FileReader java.io.File)
;
;=> (safe [s (new FileReader (new File "file.txt"))] (.read s))
;104
;The return value 104 is the first byte in the file "file.txt".

(defmacro safe [vect & expr]                                    
  (let [vect (if (and (even? (count vect)) (vector? vect)) vect [])  ; kollar att vektorn har rätt format                                                     
        expr    (if-not (empty? vect) expr (cons vect expr))    	; om bindings är tom så kör forms, annars kör (cons bindings? forms)) vilket skapar en sekvens av bindings och forms                 
        except  `(catch Exception e# e#)]
    	`(let ~vect (try ~@expr ~except (finally (for [xy# vect] (if (instance? java.io.Closeable xy#) (.close xy#))))))	;försök ~forms, om den ger exception gör ~except, finally stänger FileReader om möjligt
  )
)

(import java.io.FileReader java.io.File)
(safe [s (new FileReader (new File "file.txt"))] (.read s))

;Pseudo code

;;;try (Socket s = new Socket()
;;arg = println("123");

;macro(vector[s,new Socket()],arg){
;	if(arg == safe){ ;how to check if safe?
;		close s
;		return arg ;call arg and print "123"
;	}else if(arg caused exception){
;		close s
;		return exception
;	}
;}
