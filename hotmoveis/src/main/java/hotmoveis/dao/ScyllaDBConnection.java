package hotmoveis.dao;

import java.net.InetSocketAddress;

import com.datastax.oss.driver.api.core.CqlSession;

public class ScyllaDBConnection {

	public static void conector() {

		try (CqlSession session = CqlSession.builder().addContactPoint(new InetSocketAddress("127.0.0.1", 9042)) // IP e
																													// porta
																													// do
																													// ScyllaDB
				.withLocalDatacenter("datacenter1") // Nome do datacenter padrão
				.build()) {

			System.out.println("✅ Conexão estabelecida com o ScyllaDB!");

			// Criando um keyspace se não existir
			session.execute("CREATE KEYSPACE IF NOT EXISTS BD_Catalogos "
					+ "WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};");

			// Usando o keyspace
			session.execute("USE BD_Catalogos;");

			// Criando uma tabela se não existir
			session.execute("CREATE TABLE IF NOT EXISTS tb_produto ( id UUID PRIMARY KEY, nome TEXT, categoria TEXT, cor TEXT, material TEXT, textura TEXT, marca TEXT, fabricante TEXT, garantia_meses INT, peso FLOAT, altura FLOAT, largura FLOAT, profundidade FLOAT, quant_estoque INT);");

			System.out.println("✅ Banco de dados configurado!");
		} catch (Exception e) {
			System.err.println("❌ Erro ao conectar ao ScyllaDB: " + e.getMessage());
		}
	}

}
