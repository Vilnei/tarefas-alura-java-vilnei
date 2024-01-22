package med.voll.api.medico;
//ESSA CLASSE É A ENTIDADE ELA QUE FALA QUEM É O OBJETO

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")// para ????
@Entity(name = "Medico")// para ????
@Getter// para gerar os metodos get
@NoArgsConstructor// para gerar o construtor sem argumento
@AllArgsConstructor// para gerar o contrutor com todos os argumentos
@EqualsAndHashCode(of = "id")//para ????
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)// para ????
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    private Boolean ativo;
    @Enumerated// para ????
    private Especialidade especialidade;

    @Embedded// para ????
    private Endereco endereco;
// aqui gera um construtor recebendo os dados "sem" tratamento
    public Medico(DadosCadastroMedicos dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoMedicos dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }

}
