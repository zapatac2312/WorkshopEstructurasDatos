import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		Stack<HtmlTag> pila = new Stack<>();

		//Iteramos la cola con el foreach

		for(HtmlTag tag: tags){

			//Si el tag se cierra solo, no tenemos que hacer nada con él y podemos continuar con el siguiente
			if (tag.isSelfClosing()){
				continue;
			}

			//Si el tag es de apertura lo metemos a la pila
			if (tag.isOpenTag()){
				pila.push(tag);
			}else {
				//Si no es de apertura validamos si la lista esta vacia para devolverla como null
				if (pila.isEmpty()){
					return null;
				}
				//Si la lista no esta vacia y el tag de cierre que estamos evaluando coincide con el tag de apertura que metimos en la pila en la iteracion anterior del ciclo, eliminamos el tag de apertura que esta en el parte de arriba de la pila.
				else if(tag.matches(pila.peek())){
					pila.pop();
				} else {
					return pila;
				}
			}
		}
		return pila; // this line is here only so this code will compile if you don't modify it
	}

}

