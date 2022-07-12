## Getting Started

Repositório para criação do código para a avaliação final em Estrutura de Dados

Neste projeto, pretende-se gerenciar telegramas entregues em uma agência de uma empresa de envio e entrega de correspondências que atua em todo o território brasileiro. Ainda que não ostentem a mesma popularidade de anos atrás, tal serviço ainda é oferecido por algumas empresas para comunicação de mensagens curtas e urgentes.

Ao cadastrar um telegrama, os seguintes dados deverão ser fornecidos:
1. Destinatário
2. Remetente
3. Texto da Mensagem
4. Endereço de destino (é imprescindível que nele conste unidade da federação de destino, na forma de sigla de dois caracteres.)

O uso de coleções genéricas concretas para a manipulação de mapas e tabelas de hash de telegramas é obrigatório, considerando-se, a título de função de hash, unidade da federação de destino de cada correspondência.

Também deverá ser considerada possibilidade de dois ou mais telegramas serem enviados para a mesma unidade da federação, ao que cada valor de hash deverá estar associado a uma lista.

- Associação de identificador numérico único a cada telegrama cadastrado;
- Remoção de telegramas já cadastrados (a partir da entrada dos respectivos identificadores numéricos);
- Consulta de dados de determinado telegrama (destinatário, remetente, texto da mensagem e endereço de destino), a partir da entrada do seu respectivo identificador numérico;
- Consulta de quantidade, por unidade de federação de destino, de telegramas em cujo corpo de mensagem há ocorrências de determinada palavra ou trecho de texto;
- Consultas de caráter estatístico, a saber: a) quantidade de telegramas com destino para determinada unidade da federação; b) percentual de telegramas por unidade de destino; e c) unidades da federação com maior e menor quantidade de telegramas para os quais deverão ser enviados.
