package PilhaFila;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame {

	private Pilha pilha;
	private Fila fila;

	public Interface() {
		getContentPane().setBackground(new Color(255, 255, 255));
		pilha = new Pilha();
		fila = new Fila();

		setTitle("Menu Principal");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(0, 0, 286, 31);
		mainPanel.setLayout(null);

		getContentPane().add(mainPanel);

		JTextPane txtpnInter = new JTextPane();
		txtpnInter.setFont(new Font("Arial", Font.BOLD, 20));
		txtpnInter.setText("Estrutura de Dados");
		txtpnInter.setBounds(48, 0, 191, 29);
		mainPanel.add(txtpnInter);

		JButton pilhaButton = new JButton("Pilha");
		pilhaButton.setBounds(46, 94, 74, 36);
		getContentPane().add(pilhaButton);
		pilhaButton.setBackground(new Color(240, 240, 240));
		JButton filaButton = new JButton("Fila");
		filaButton.setBounds(166, 94, 74, 36);
		getContentPane().add(filaButton);
		filaButton.setBackground(new Color(240, 240, 240));
		
		JTextArea txtrSelecioneAEstrutura = new JTextArea();
		txtrSelecioneAEstrutura.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrSelecioneAEstrutura.setText("  Selecione a estrutura desejada:");
		txtrSelecioneAEstrutura.setBounds(46, 64, 194, 22);
		getContentPane().add(txtrSelecioneAEstrutura);

		filaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirOpcoesFila();
			}
		});

		pilhaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirOpcoesPilha();
			}
		});
	}

	private void exibirOpcoesPilha() {
		JFrame framePilha = new JFrame("Métodos da Pilha");
		framePilha.setSize(300, 300);
		framePilha.setLocationRelativeTo(null);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		framePilha.getContentPane().add(scrollPane);

		JButton vaziaButton = new JButton("Vazia");
		vaziaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.append(String.valueOf(pilha.vazia()));
			}
		});

		JButton inserirButton = new JButton("Inserir");
		inserirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String input = JOptionPane.showInputDialog(null, "Digite o número para inserir:");
				try {
					int value = Integer.parseInt(input);
					pilha.inserir(value);
					textArea.setText("");
					textArea.append("Elemento inserido com sucesso!");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Digite um número válido.");
				}
			}
		});

		JButton removerButton = new JButton("Remover");
		removerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				try {
					int elementoRemovido = pilha.remover();
					textArea.append("Elemento '" + elementoRemovido + "' removido com sucesso!");
				} catch (IllegalStateException ex) {
					textArea.append(ex.getMessage());
				}
			}
		});

		JButton mostrarElementosButton = new JButton("Mostrar Elementos");
		mostrarElementosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				pilha.mostrarElementos(textArea);
			}
		});

		JButton topoButton = new JButton("Topo");
		topoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				try {
					int topElement = pilha.topo();
					textArea.append("Topo da pilha: " + topElement);
				} catch (IllegalStateException ex) {
					textArea.setText("");
					textArea.append(ex.getMessage());
				}
			}
		});

		JButton buscarElementoButton = new JButton("Buscar Elemento");
		buscarElementoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String input = JOptionPane.showInputDialog(null, "Digite o número a ser buscado:");
				try {
					int element = Integer.parseInt(input);
					boolean encontrado = pilha.buscarElemento(element);
					textArea.setText("");
					textArea.append("Elemento encontrado: " + encontrado);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Digite um número válido.");
				}
			}
		});

		JButton tamanhoButton = new JButton("Tamanho");
		tamanhoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.append(String.valueOf(pilha.tamanho()));
			}
		});

		JButton esvaziarButton = new JButton("Esvaziar");
		esvaziarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				pilha.esvaziar();
				textArea.append("Pilha esvaziada!");
			}
		});

		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePilha.dispose();
			}
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 2));
		buttonPanel.add(vaziaButton);
		buttonPanel.add(inserirButton);
		buttonPanel.add(removerButton);
		buttonPanel.add(mostrarElementosButton);
		buttonPanel.add(topoButton);
		buttonPanel.add(buscarElementoButton);
		buttonPanel.add(tamanhoButton);
		buttonPanel.add(esvaziarButton);
		buttonPanel.add(voltarButton);

		framePilha.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		framePilha.setSize(500, 300);
		framePilha.setLocationRelativeTo(null);
		framePilha.setVisible(true);
	}

	private void exibirOpcoesFila() {
		JFrame frameFila = new JFrame("Métodos da Fila");
		frameFila.setSize(300, 300);
		frameFila.setLocationRelativeTo(null);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		frameFila.getContentPane().add(scrollPane);

		JButton vaziaButton = new JButton("Vazia");
		vaziaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.append(String.valueOf(fila.vazia()));
			}
		});

		JButton inserirButton = new JButton("Inserir");
		inserirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String input = JOptionPane.showInputDialog(null, "Digite o número para inserir:");
				try {
					int value = Integer.parseInt(input);
					fila.inserir(value);
					textArea.setText("");
					textArea.append("Elemento '" + input + "' adicionado com sucesso!");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Digite um número válido.");
				}
			}
		});

		JButton removerButton = new JButton("Remover");
		removerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				try {
					int elementoRemovido = fila.remover();
					textArea.append("Elemento '" + elementoRemovido + "' removido com sucesso!");
				} catch (IllegalStateException ex) {
					textArea.append(ex.getMessage());
				}
			}
		});

		JButton mostrarElementosButton = new JButton("Mostrar Elementos");
		mostrarElementosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				fila.mostrarElementos(textArea);
			}
		});

		JButton inicioButton = new JButton("Inicio");
		inicioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				try {
					int inicioElement = fila.inicio();
					textArea.append("Início da fila: " + inicioElement);
				} catch (IllegalStateException ex) {
					textArea.append(ex.getMessage());
				}
			}
		});

		JButton fimButton = new JButton("Fim");
		fimButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				try {
					int fimElement = fila.fim();
					textArea.append("Fim da fila: " + fimElement);
				} catch (IllegalStateException ex) {
					textArea.append(ex.getMessage());
				}
			}
		});

		JButton buscarElementoButton = new JButton("Buscar Elemento");
		buscarElementoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String input = JOptionPane.showInputDialog(null, "Digite o número a ser buscado:");
				try {
					int element = Integer.parseInt(input);
					boolean encontrado = fila.buscarElemento(element);
					textArea.setText("");
					textArea.append("Elemento encontrado: " + encontrado);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Digite um número válido.");
				}
			}
		});

		JButton tamanhoButton = new JButton("Tamanho");
		tamanhoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.append(String.valueOf(fila.tamanho()));
			}
		});

		JButton esvaziarButton = new JButton("Esvaziar");
		esvaziarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				fila.esvaziar();
				textArea.append("Fila esvaziada!");
			}
		});

		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameFila.dispose();
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 2));
		buttonPanel.add(vaziaButton);
		buttonPanel.add(inserirButton);
		buttonPanel.add(removerButton);
		buttonPanel.add(mostrarElementosButton);
		buttonPanel.add(inicioButton);
		buttonPanel.add(fimButton);
		buttonPanel.add(buscarElementoButton);
		buttonPanel.add(tamanhoButton);
		buttonPanel.add(esvaziarButton);
		buttonPanel.add(voltarButton);

		frameFila.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		frameFila.setSize(500, 300);
		frameFila.setLocationRelativeTo(null);
		frameFila.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Interface menu = new Interface();
				menu.setVisible(true);
			}
		});
	}
}
