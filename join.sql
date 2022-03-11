select cliente.nome, cliente.email, pedido.numero, pedido.data, 
       pedido_produto.quantidade, produto.nome, pedido_produto.preco_unit, pedido_produto.preco_total, pedido.valor_total
from 
     pedido 
         inner join pedido_produto on pedido.numero = pedido_produto.num_pedido
         inner join produto on pedido_produto.cod_produto = produto.codigo
         inner join cliente on pedido.num_cliente = cliente.numero;