
package com.project.base;

/**
 *
 * @author seweryn
 */
public interface UseCase<REQUEST_OBJECT,RESPONSE_OBJECT> {
    
    RESPONSE_OBJECT execute(REQUEST_OBJECT request) throws Throwable;
    
}
