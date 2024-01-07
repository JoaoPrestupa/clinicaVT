package br.com.clinicavt.models.user;

public record RegisterDto(String username, String password, Role role) {
}
