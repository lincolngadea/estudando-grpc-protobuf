package br.com.zup.grpc

import java.io.FileInputStream
import java.io.FileOutputStream

fun main(){

    val request = FuncionarioRequest.newBuilder()
        .setNome("Lincoln Gadea")
        .setCpf("000.000.000.000")
        .setSalario(10000.0)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua B")
            .setCep("000000-00")
            .setComplemento("Conj. A")
            .build())
        .build()

    println(request)
    request.writeTo(FileOutputStream("funcionario-request.bin"))//grava informações em disco

    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.GERENTE)
        .build()

    println(request2)
}