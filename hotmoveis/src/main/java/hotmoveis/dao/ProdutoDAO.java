package hotmoveis.dao;

import java.net.InetSocketAddress;
import java.util.UUID;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import hotmoveis.controller.Categoria;
import hotmoveis.controller.Produto;

public class ProdutoDAO {

	private static final String KEYSPACE = "BD_Catalogos";

    private CqlSession session;

    public ProdutoDAO() {
        this.session = CqlSession.builder()
                .addContactPoint(new InetSocketAddress("127.0.0.1", 9042))
                .withLocalDatacenter("datacenter1")
                .build();
    }

    public void inserirProduto(Produto produto) {
        UUID id = UUID.randomUUID();
        PreparedStatement stmt = session.prepare(
                "INSERT INTO " + KEYSPACE + ".tb_produto (id, altura, categoria, cor, fabricante, garantia_meses, largura, marca, material, nome, peso, profundidade, quant_estoque, textura) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );
        session.execute(stmt.bind(id, produto.getAltura(), produto.getCategoria().toString(), produto.getCorString(), produto.getFabricanteString(), produto.getGarantiaMeses(), produto.getLargura(), produto.getMarca(), produto.getMaterialString(), produto.getNomeString(), produto.getPeso(), produto.getProfundidade(), produto.getQuantEstoque(), produto.getTexturaString()));
        System.out.println("✅ Usuário inserido com sucesso!");
    }

    public void buscarProdutos() {
        ResultSet resultSet = session.execute("SELECT * FROM " + KEYSPACE + ".tb_produto;");
        for (Row row : resultSet) {
            System.out.println("ID: " + row.getUuid("id") +
                    ", Nome: " + row.getString("nome") +
                    ", categoria: " + row.getString("categoria"));
        }
    }

    public static void main(String[] args) {
    	
    	ScyllaDBConnection.conector();
    	
    	 ProdutoDAO dao = new  ProdutoDAO();
    	 Produto produto = new Produto("Armário", Categoria.COZINHA, "Preto", "Compensado de Madeira", "Liso", "Nicioli" , "INOVA_MOVEIS", 12, 42 , 136, 180, 33, 10);
        
        // Inserindo um usuário
        dao.inserirProduto(produto);
        
        // Buscando usuários
        dao.buscarProdutos();
    }
}
