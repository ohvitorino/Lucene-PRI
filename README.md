# Lucene-PRI
Lucene Simple Index and Search Application

# Portuguese help

Exemplos de utilização:

`java -jar indexer_pt.jar -index index_pt -docs samples -Dcom.sun.management.jmxremote=true -Xmx1g`

Este comando efetua a indexação em português dos documentos existentes em samples e gera o index na diretoria index_pt. Os parâmetros extra são para permitir a monitorização do processo, e aumentar o limite de memória.

------------------------------------------------------------------------------------------------

`java -jar indexer_simple.jar -index index_simple -docs samples -Dcom.sun.management.jmxremote=true -Xmx1g`

Tal como o exemplo anterior, mas utilizando o SimpleAnalyzer e gerando o index noutra directoria.

-------------------------------------------------------------------------------------------------

`java -jar searcher.jar -index index_pt  -Dcom.sun.management.jmxremote=true`

Exemplo de pesquisa utilizando o index gerado com base no Analyzer de Português.