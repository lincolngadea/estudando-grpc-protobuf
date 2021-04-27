package br.com.zup.grpc

import io.grpc.ManagedChannelBuilder

fun main(){

    val channel = ManagedChannelBuilder
        .forAddress("localhost",50051)
        .usePlaintext()
        .build()

    val request = FuncionarioRequest.newBuilder()
        .setNome("Lincoln Gadea")
        .setCpf("000.000.000.000")
        .setIdade(39)
        .setSalario(10000.0)
        .setAtivo(true)
        .setCargo(Cargo.QA)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua B")
            .setCep("000000-00")
            .setComplemento("Conj. A")
            .build())
        .build()

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    val response = client.cadastrar(request)

    println(response)
}