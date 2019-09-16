package caixaeletronico;

public class ContaCorrente {
    private String nomeCliente;
    private int numeroConta;
    private int numeroAgencia;
    private String senhaConta;
    private boolean statusConta;
    private double saldo;
    private double limiteChequeEspecial;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nome) {
        this.nomeCliente = nome;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int conta) {
        this.numeroConta = conta;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int agencia) {
        this.numeroAgencia = agencia;
    }

    public String getSenhaConta() {
        return senhaConta;
    }

    public void setSenhaConta(String senha) {
        this.senhaConta = senha;
    }

    public boolean getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(boolean status) {
        this.statusConta = status;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double s) {
        this.saldo = s;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limite) {
        this.limiteChequeEspecial = limite;
    }
    
    public double depositar(double valor) {
        if( valor > 0 ) {
            double novoSaldo = this.getSaldo() + valor;
            this.setSaldo(novoSaldo);
        } else {
            System.err.println("Valor inválido. Tente digitar um valor positivo");
        }
        return this.getSaldo();
    }
    
    public double sacar(double valor) {
        if( this.getSaldo() >= valor ) {
            double novoSaldo = this.getSaldo() - valor;
            this.setSaldo(novoSaldo);
        } else {
            System.err.println("Saldo insuficiente.");
        }
        return this.getSaldo();
    }
    
    public double sacarDoChequeEspecial(double valor) {
        if( this.getSaldo() + this.getLimiteChequeEspecial() >= valor ) {
            double novoSaldo = this.getSaldo() - valor;
            this.setSaldo(novoSaldo);
        } else {
            System.err.println("Limite do cheque especial insuficiente.");
        }
        return this.getSaldo();
    }
    
    public double transferir(double valor, int conta, int agencia) {
        if( this.getSaldo() >= valor ) {
            double novoSaldo = this.getSaldo() - valor;
            this.setSaldo(novoSaldo);
            System.out.println("Transferência efetuada com sucesso.");
            System.out.println("Comprovante");
            System.out.println("______________________");
            System.out.println("Transferência de ");
            System.out.println("R$ " + valor);
            System.out.println("Da conta " + this.getNumeroConta());
            System.out.println("Para a: AGÊNCIA: " + agencia + " CONTA: " + conta);
            System.out.println("______________________");
        }
        
        return this.getSaldo();
    }
    
    public boolean encerrarConta(int conta, int agencia) {
        if( this.getNumeroConta() != conta ) {
            System.err.println("Conta inválida");
            return false;
        }
        if( this.getNumeroAgencia() != agencia ) {
            System.err.println("Agência inválida");
            return false;
        }
        if( this.getStatusConta() ) {
            System.err.println("A conta já está inativa");
            return false;
        }
        
        this.setStatusConta( false );
        System.out.println("Conta encerrada com sucesso");
        return true;       
        
    }
    


    
}
