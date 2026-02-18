package com.delivery.produto.exception;

import java.util.Map;

public record ErrorResponse(String mensagem, Map<String, String> campos) {
}