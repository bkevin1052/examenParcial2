
import java.util.Scanner;
import gt.edu.url.examen2.problema2.*;
import gt.edu.url.examen2.problema3.Position;
import gt.edu.url.examen2.problema3.PositionalLinkedList;
import gt.edu.url.examen2.problema5.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opt = 0;
		
		
		do {
			
			System.out.println("****EXAMEN PARCIAL 2****");
			System.out.println("1. PROBLEMA 1");
			System.out.println("2. PROBLEMA 2");
			System.out.println("3. PROBLEMA 3");
			System.out.println("4. PROBLEMA 4");
			System.out.println("5. SALIR");
			opt = sc.nextInt();
			
			switch(opt) {
			
			case 1:
				System.out.println("****PROBLEMA 1****");
				ArrayList<Integer> ListaProblema1 = new ArrayList<>();
				ListaProblema1.crearDemoLista();
				
			break;
				
			case 2:
				System.out.println("****PROBLEMA 2****");
				String elemento;
				Position<String> a1,a2;
				PositionalLinkedList<String> ListaPosicional = new PositionalLinkedList<>();
				
				System.out.println("Ingrese un nombre:");
				elemento = sc.next();
				a1 = ListaPosicional.addFirst(elemento);
				
				System.out.println("Ingrese un nombre:");
				elemento = sc.next();
				a2 = ListaPosicional.addAfter(a1, elemento);
				
				
				
			    System.out.println(a1.getElement());
			    System.out.println(a2.getElement());
				
				ListaPosicional.swap(a1, a2);
				
				System.out.println("Intercambiados");
				

				 System.out.println(a1.getElement());
				 System.out.println(a2.getElement());
				
				
				
			break;
				
			case 3:
				System.out.println("****PROBLEMA 3****");
				String element;
				gt.edu.url.examen2.problema4.Position<String> a,b,c;
				gt.edu.url.examen2.problema4.PositionalLinkedList<String> ListaProblema4 = new gt.edu.url.examen2.problema4.PositionalLinkedList<>();
				
				System.out.println("Ingrese el dato [1]");
				element = sc.next();
			    a = ListaProblema4.addFirst(element, 0);
			    ListaProblema4.positionAtIndex(0, a);
			    
			    System.out.println("Ingrese el dato [2]");
				element = sc.next();
			    b = ListaProblema4.addLast(element, 1);
			    ListaProblema4.positionAtIndex(1, b);
			    
			    System.out.println("Ingrese el dato [3]");
				element = sc.next();
			    c = ListaProblema4.addLast(element, 2);
			    ListaProblema4.positionAtIndex(2, c);
			    
				System.out.println("DATOS CONTENIDOS EN LA LISTA:");
				
				System.out.println("PRIMERO");
				System.out.println(ListaProblema4.first(0).getElement());
				
			    System.out.println("Indice{1}"+ListaProblema4.remove(a, 0));
			    System.out.println("Indice{2}"+ListaProblema4.remove(b, 1));
			    System.out.println("Indice{3}"+ListaProblema4.remove(c, 2));
			    
			
				
			break;
				
			case 4:
				System.out.println("****PROBLEMA 4****");
				
				int numero;
				String opt1;
				
				ArrayPila<Integer> DynamicStack = new ArrayPila<>();
				do {
				System.out.println("Ingrese un numero");
				numero = sc.nextInt();
				DynamicStack.push(numero);
				}while(DynamicStack.size()!=10);
			break;
			
			default:
				break;
			
			}
			
			
		}while(opt!=5);
		

	}

}
