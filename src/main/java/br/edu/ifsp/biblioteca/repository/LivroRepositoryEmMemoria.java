package br.edu.ifsp.biblioteca.repository;

import br.edu.ifsp.biblioteca.domain.Livro;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("memoria")
public class LivroRepositoryEmMemoria implements ILivroRepository{

    private final Map<Long, Livro> livros = new HashMap<Long, Livro>();
    private Long sequenciaId = 0L;

    @Override
    public Livro salvar(Livro livro) {
        if (livro.getId() == null){
            this.sequenciaId++;
            livro.setId(this.sequenciaId);
        }
        
        this.livros.put(livro.getId(), livro);
        
        return livro;
    }

    @Override
    public List<Livro> listarTodos() {
        return new ArrayList<>(this.livros.values() );
    }

    @Override
    public Optional<Livro> buscarPorId(Long Id) {
        
        return Optional.ofNullable(this.livros.get(Id));
        
        /* Usando if's*/
//        Livro l = this.livros.get(Id);
//        
//        if (l == null){
//            return Optional.empty();
//        }
//        
//        return Optional.empty();
    }

    @Override
    public Optional<Livro> buscarPorIsbn(String isbn) {
        
       List<Livro> colecaoLivros = new ArrayList<>(this.livros.values());

       /* for each*/
       for (Livro livro : colecaoLivros){ //para cada livro, percorra coleção
           if (livro.getIsbn().equalsIgnoreCase(isbn))
               return Optional.of(livro);
       }

//       for (int i = 0; i < colecaoLivros.size(); i++){
//           Livro livro = colecaoLivros.get(i);
//           if (livro.getIsbn().equalsIgnoreCase(isbn))
//               return Optional.of(livro);
//       }
//
        return Optional.empty();
    }

    @Override
    public List<Livro> buscarPorTitulo(String titulo) {

        List<Livro> colecaoLivros = new ArrayList<>(this.livros.values());
        List<Livro> contemTitulo = new ArrayList<>();

        for (Livro livro : colecaoLivros){
            if (livro.getTitulo().toLowerCase().equalsIgnoreCase(titulo) )
                contemTitulo.add(livro);
        }

        return (contemTitulo);
    }
}
