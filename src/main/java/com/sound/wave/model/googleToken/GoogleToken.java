package com.sound.wave.model.googleToken;

import lombok.Data;

@Data
public class GoogleToken {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
