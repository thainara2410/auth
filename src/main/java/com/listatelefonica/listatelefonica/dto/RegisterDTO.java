package com.listatelefonica.listatelefonica.dto;

import com.listatelefonica.listatelefonica.enumerador.UserRole;

public record RegisterDTO(String login, String password, UserRole role){
    
}
