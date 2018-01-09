
package com.project.base;

/**
 * @author seweryn
 * 
 * Ten interfejs realizuje wzorzec polecenia. UseCase jest obiektem który 
 * może wykonać operacje, przyjmując argumentu (REQUEST_OBJECT) oraz 
 * zwracającą wynik (RESPONSE_OBJECT). Operacja UseCase'a zazwyczaj odpowiada 
 * za rozwiązanie biznesowego przypadku użycia i jest wywołaniem blokującym.
 * UseCase może zostać wykonany bezpośrednio wywołując metodę execute() lub
 * za pomocą UseCaseExecutor'a.
 * 
 * @param <REQUEST_OBJECT> - typ argumentu operacji
 * @param <RESPONSE_OBJECT> - typ wyniku operacji
 */
public interface UseCase<REQUEST_OBJECT,RESPONSE_OBJECT> {
    
    /**
     * @param request - argument operacji
     * @return - wynik operacji
     * @throws Throwable - błąd zgłoszony podczas wykonania 
     */
    RESPONSE_OBJECT execute(REQUEST_OBJECT request) throws Throwable;
    
}
