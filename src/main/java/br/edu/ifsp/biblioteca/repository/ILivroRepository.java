package br.edu.ifsp.biblioteca.repository;

import br.edu.ifsp.biblioteca.domain.Livro;

import java.util.List;
import java.util.Optional;

public interface ILivroRepository {

    public Livro salvar(Livro livro);

    public List<Livro> listarTodos();

    public Optional<Livro> buscarPorId(Long Id);

    public Optional<Livro> buscarPorIsbn(String isbn);

    public List<Livro> buscarPorTitulo(String titulo);
}
