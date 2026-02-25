package br.com.nogueiranogueira.aularefatoracao.solidproject.model;

import jakarta.persistence.DiscriminatorValue;

@DiscriminatorValue("VIP")
public class UsuarioVIP extends Usuario{

    private boolean temCartaoFidelidade;

    public boolean isTemCartaoFidelidade() {
        return temCartaoFidelidade;
    }

    public void setTemCartaoFidelidade(boolean temCartaoFidelidade) {
        this.temCartaoFidelidade = temCartaoFidelidade;
    }

    @Override
    public int getDesconto() {
        if (!temCartaoFidelidade) {
            return 0;
        }
        return 10;
    }
}
