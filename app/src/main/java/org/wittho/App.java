/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.wittho;

import org.wittho.controller.EventoController;
import org.wittho.model.EventoModel;
import org.wittho.repository.EventoRepository;
import org.wittho.service.EventoService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    final EventoRepository eventoRepository = new EventoRepository();
    final EventoService eventoService = new EventoService(eventoRepository);
    final EventoController eventoController = new EventoController(eventoService);

    Scanner scan = new Scanner(System.in);
    String opcao = "0";

    System.out.println("Gerenciador de eventos.");
    while(!opcao.equals("4")) {
      System.out.println("Informe o número da opção desejada.");
      System.out.println("1 - Cadastrar novo evento");
      System.out.println("2 - Listar os evento cadastrados");
      System.out.println("3 - Listar os evento futuros");
      System.out.println("4 - Encerrar o programa");

      opcao = scan.nextLine();

      if (opcao.equals("1")) {
        cadastrarEvento(eventoController);
      } else if (opcao.equals("2")) {
        System.out.println(eventoController.buscarEvento());
      } else if (opcao.equals("3")) {
        System.out.println(eventoController.listarEventosFuturos());
      } else if (opcao.equals("4")) {
        System.out.println("Programa encerrado.");
      }
    }
  }

  private static void cadastrarEvento(EventoController eventoController) {
    Scanner scan = new Scanner(System.in);
    EventoModel novoEvento = new EventoModel();

    System.out.print("Informe o nome do evento: ");
    novoEvento.setNome(scan.nextLine());

    System.out.print("Informe o endereço do evento: ");
    novoEvento.setEndereco(scan.nextLine());

    System.out.println("Informe o número da categoria do evento: ");
    System.out.println("1 - Show\n2 - Festa\n3 - Evento Esportivo");
    String categoria = scan.nextLine();

    if (categoria.equals("1")) {
      novoEvento.setCategoria("Show");
    } else if (categoria.equals("2")) {
      novoEvento.setCategoria("Festa");
    } else if (categoria.equals("3")) {
      novoEvento.setCategoria("Evento Esportivo");
    }

    System.out.print("Informe a data do evento: ");
    String data = scan.nextLine();

    System.out.print("Informe o horário do evento: ");
    String horario = scan.nextLine();

    DateTimeFormatter formatoDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime dataHora = LocalDateTime.parse(data + " " + horario, formatoDateTime);
    novoEvento.setHorario(dataHora);

    System.out.print("Informe a descrição do evento: ");
    novoEvento.setDescricao(scan.nextLine());

    System.out.println(eventoController.salvarEvento(novoEvento));
  }
}
