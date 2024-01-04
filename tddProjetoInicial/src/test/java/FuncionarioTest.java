import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;


public class FuncionarioTest {

    @Test
    public void deveriaRetornarNome(){
        Funcionario func = new Funcionario("Adalberto", LocalDate.now(), new BigDecimal("1000"));
        String nome = func.getNome();

        assertEquals("Adalberto", nome);
    }

    @Test
    public void deveRetornarSalario(){
        Funcionario func = new Funcionario("Adalberto", LocalDate.now(), new BigDecimal("1000"));
        BigDecimal salario = func.getSalario();

        assertEquals(new BigDecimal("1000"), salario);
    }

    @Test
    public void deveRetornarDataDeAdimicao(){
        Funcionario func = new Funcionario("Adalberto", LocalDate.now(), new BigDecimal("1000"));
        LocalDate data = func.getDataAdmissao();

        assertEquals(LocalDate.now(), data);
    }
}
