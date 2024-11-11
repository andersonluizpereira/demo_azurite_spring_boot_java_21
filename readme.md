```bash
curl -X POST http://localhost:8080/api/books \
-H "Content-Type: application/json" \
-d '{
    "isbn": "978-3-16-148410-1",
    "tipoLivro": "Novo",
    "estante": "Ficção",
    "idioma": "Português",
    "titulo": "Aventuras no Mundo da Programação",
    "autor": "João da Silva",
    "editora": "Programadores Editora",
    "ano": 2023,
    "edicao": 1,
    "preco": 49.9,
    "peso": 300,
    "descricao": "Um livro sobre aventuras no mundo da programação.",
    "capa": "link_da_imagem.jpg"
}'
```
```bash
curl -X GET http://localhost:8080/api/books/978-3-16-148410-1
```
```bash
curl -X PUT http://localhost:8080/api/books/978-3-16-148410-1 \
-H "Content-Type: application/json" \
-d '{
    "isbn": "978-3-16-148410-1",
    "tipoLivro": "Usado",
    "estante": "Ficção",
    "idioma": "Português",
    "titulo": "Aventuras no Mundo da Programação - Edição Atualizada",
    "autor": "João da Silva",
    "editora": "Programadores Editora",
    "ano": 2023,
    "edicao": 2,
    "preco": 45.0,
    "peso": 320,
    "descricao": "Edição atualizada com novas aventuras no mundo da programação.",
    "capa": "link_da_imagem_atualizada.jpg"
}'
```
```bash
curl -X DELETE http://localhost:8080/api/books/978-3-16-148410-1
```
```bash
curl -X GET http://localhost:8080/api/books
```
