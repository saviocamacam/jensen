package jensen;

import java.util.LinkedList;
import java.util.Random;

public class Schedule {
	private LinkedList<Operacao> scheduleinlist;
	private int itemdado;
	private int transacao;
	private int acesso;
	
	public Schedule(String nomeArquivo) {
		LinkedList<Transacao> transacao = ArquivoManager.lerArquivoTransacao(nomeArquivo);
		scheduleinlist = new LinkedList<>();
		ligaOperacoes(transacao);
	}
	
	public Schedule() {
		scheduleinlist = new LinkedList<>();
	}
	//m�todo que sorteia as opera��es no schedule retirando uma a uma das transacoes
	private void ligaOperacoes(LinkedList<Transacao> listaTransacao) {
		Random r = new Random();
		while( !listaTransacao.isEmpty() ){
	       	int n = r.nextInt(listaTransacao.size());
	       	if(!listaTransacao.get(n).transIsEmpty()) {
	       		scheduleinlist.add(listaTransacao.get(n).getFirstOp());
	       		listaTransacao.get(n).removeOp();
	       	} else {
	       		listaTransacao.remove(n);
	       	}
		   }
	}
	
	public void cabecalho(String linha0) {
		String[] temp2 = linha0.substring(0).split(", ");
		this.acesso = Integer.parseInt(temp2[2].toString());
		this.itemdado = Integer.parseInt(temp2[0].toString());
		this.transacao = Integer.parseInt(temp2[1].toString());
	}

	public LinkedList<Operacao> getScheduleinlist() {
		return scheduleinlist;
	}

	public int getItemdado() {
		return itemdado;
	}

	public int getTransacao() {
		return transacao;
	}

	public int getAcesso() {
		return acesso;
	}

	@Override
	public String toString() {
		String str = "";
		for (Operacao op : scheduleinlist) {
			str += op.toString() + " ";
		}
		return str;
	}

	public void setScheduleinlist(LinkedList<Operacao> scheduleinlist) {
		this.scheduleinlist = scheduleinlist;
	}
}
