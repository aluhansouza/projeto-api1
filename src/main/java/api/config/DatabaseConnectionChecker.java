package api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class DatabaseConnectionChecker implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			jdbcTemplate.execute("SELECT 1");
			System.out.println("Conexão com Sucesso");
		}
		catch(Exception ex){
			System.err.println("Erro ao conectar "+ex.getMessage());
		}
		
	}
	
	
	

}
