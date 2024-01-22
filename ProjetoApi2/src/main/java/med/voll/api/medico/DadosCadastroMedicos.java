package med.voll.api.medico;

import jakarta.validation.Valid;// para dizer que esse campo e outro DTO e que vai ter anotaçoes dentro desse campo, tipo objeto dentro de objeto
import jakarta.validation.constraints.Email;//ja faz as validaçoes de email como @blabla.com
import jakarta.validation.constraints.NotBlank;//diz que n pode se null nem em branco PORÉM SO PARA STRING
import jakarta.validation.constraints.NotNull;// diz que n pode ser null (mas pode ser em branco) e serve para String ou int etc
import jakarta.validation.constraints.Pattern;//defini qual padrão eu quero usar dentro da função
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedicos(
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank @Pattern(regexp = "\\d{4,6}")// o "\\d quer dizer digito e dentro de {} vai a variação de 4 a 6 digitos
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid
        DadosEndereco endereco ) {
}
