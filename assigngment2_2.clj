; ASSIGNMENT 2 SQL-like macro
;
;The second macro should implement an SQL-like syntax for searching in lists of maps, as illustrated
;by the following example:
;=> (def persons '({:id 1 :name "olle"} {:id 2 :name "anna"} {:id 3 :name
;"isak"} {:id 4 :name "beatrice"}))
;...
;=> (select [:id :name] from persons where [:id > 2] orderby :name)
;({:id 4 :name "beatrice"} {:id 3 :name "isak"})
;The query format should be:
;(select [columns] from #{table} where :column (op value) orderby :column)
;where the condition operator 'op' is one of the following: = < > <>

(defmacro selectSQL [[columns] from #{table} where [:column op value] orderby :column]                                              
	
)

(def persons '({:id 1 :name "olle"} {:id 2 :name "anna"} {:id 3 :name
"isak"} {:id 4 :name "beatrice"}))

(selectSQL [:id :name] from persons where [:id > 2] orderby :name)
