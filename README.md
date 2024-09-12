### Alunos: César Eduardo de Souza e Lucas Ziemann
Objetivo: simulação da distribuição de carga de um pedágio para registro de pagamentos
Composição das mensagens que serão trocadas:
a. Placa do carro (vetor composto por 7 caracteres aleatórios).
b. Valor pago [1,10].
c. Identificador do serviço (exemplo: AD1, AD2 ou AD3).
d. ...

Número de filas no sistema (para cada dupla):
a. Cada prestador de serviço terá uma fila?
b. Como registrar os pagantes que não tem adesivo no carro?

Ação dos servidores/serviços:
a. Cada servidor recuperará mensagens das filas e registrará o valor recebido.

Ação das cabines de coleta:
a. Como a cabine receberá a resposta liberando o carro?

Demonstração da funcionalidade
a. Demonstre com logs(ou outra funcionalidade) as informações salvas pelos servidores e as ações das cabines de pedágio.
