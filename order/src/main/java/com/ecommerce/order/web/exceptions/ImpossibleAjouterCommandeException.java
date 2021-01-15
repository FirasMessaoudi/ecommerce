package com.ecommerce.order.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
Si on en arrive à cette exception, c'est qu'il y a eu une erreur interne
Si la requête était mal formée, elle aurait déclenché 400 Bad Request automatiquement
**/

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ImpossibleAjouterOrderException extends RuntimeException {

    public ImpossibleAjouterOrderException(String message) {
        super(message);
    }
}
