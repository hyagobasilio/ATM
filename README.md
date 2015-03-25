	##EXPLORADOR DE MARTE

	<p>Um grupo de robôs viajantes da NASA está prestes a desembarcar em uma planície de Marte. Esta planície, a qual é curiosamente retangular, deve ser explorada por estes robôs para que suas câmeras on-board possam mapear a vista do terreno que os envolve e enviar as imagens de volta à Terra.
A posição do robô viajante e sua localização é representada pela combinação de coordenadas X e Y e de uma letra representando uma das quatro posições cardeais. A planície é dividida em uma matriz para facilitar a navegação. Um exemplo de posição poderia ser 0, 0, N, o que significa que o robô está no canto inferior esquerdo, virado para o Norte.
Como forma de controlar o robô viajante, a NASA envia uma simples String de letras. As letras possíveis são ‘L’, ‘R’ e ‘M’. ‘L’ e ‘R’ fazem o robô girar 90° para a esquerda ou para a direita, respectivamente, sem movê-lo de sua posição atual. ‘M’ significa que o robô deve se mover uma posição para frente mantendo a mesma direção original.
Assuma que o Norte da matriz de (x, y) é (x, y+1).</p>

	##ENTRADA:

	A primeira linha da entrada é o lado superior direito da planície, o lado inferior esquerdo é (0, 0).
O resto dos dados de entrada referem-se aos robôs viajantes que já estão preparados nas suas respectivas planícies em marte. Cada robô recebe duas linhas de entrada. A primeira linha revela a posição e a segunda linha é uma série de intruções que informa como o robô deve explorar a planície.
A posição consiste de dois números inteiros e de uma letra, separados por espaços em branco, correspondendo às coordenadas X e Y e a orientação robô.
Cada robô explorador finalizará a tarefa de forma sequencial, ou seja, o segundo robô só irá se mover após o primeiro já ter completado sua tarefa.

	##SAÍDA ESPERADA</h2>
	<p>A saída para cada robô deve ser sua coordenada final e a orientação para onde está apontado.</p>

##ENTRADA E SAÍDA
###Teste de entrada:

5 5
	1 2 N 
	LMLMLMLMM
	3 3 E 
	MMRMMRMRRM
	Expected Output: <br>
	1 3 N <br>
	5 1 E </p>
