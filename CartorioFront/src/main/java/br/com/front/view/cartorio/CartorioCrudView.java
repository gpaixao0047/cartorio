package br.com.front.view.cartorio;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.modelmapper.ModelMapper;

import br.com.front.bean.CartorioBean;
import br.com.front.bean.CartorioCertidaoBean;
import br.com.front.bean.CertidaoBean;
import br.com.front.controller.CartorioController;
import lombok.Data;


@SessionScoped
@ManagedBean(name = "cartoriorCrudView")
@Data
public class CartorioCrudView extends CartorioBean {
	
	private List<CartorioBean> listCartorioBean;
	private CartorioBean cartorioBeanEdit;
	private List<CertidaoBean> listCertidaoBean;
	private List<Integer> listCertidaoBeanParaSalvar;

	
	@PostConstruct
	private void init() {
		try {
			listCartorioBean = CartorioController.listaCartorios();
			listCertidaoBean = CartorioController.listaCertidoes();
			cartorioBeanEdit = new CartorioBean();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void saveOrUpdate() throws Exception {
		if(cartorioBeanEdit.getIdCartorio() != null) {
			atualizar();
		}else {
			cadastrar();
		}
		
	}
	
	private void atualizar() throws Exception {
		CartorioController.cadastrar(new CartorioBean(cartorioBeanEdit.getIdCartorio(),this.getNome(),this.getEndereco()));
		listCartorioBean = CartorioController.listaCartorios();
		salvarVinculoCartorioCertidao(cartorioBeanEdit.getIdCartorio(), listCertidaoBeanParaSalvar);
		new ModelMapper().map(new CartorioBean(),this);
		cartorioBeanEdit = new CartorioBean();
		FacesMessage message = new FacesMessage("Atualizado com sucesso!!");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	public void delete(CartorioBean cartorioBean) throws Exception {
		CartorioController.deleteById(cartorioBean.getIdCartorio());
		listCartorioBean = CartorioController.listaCartorios();
	}
	
	public void limparCampos() {
		listCertidaoBeanParaSalvar = new ArrayList<Integer>();
		cartorioBeanEdit = new CartorioBean();
		new ModelMapper().map(new CartorioBean(),this);
	}
	
	public void editar(CartorioBean cartorioBean) throws Exception {
		cartorioBeanEdit = cartorioBean;
		this.setNome(cartorioBean.getNome());
		this.setEndereco(cartorioBean.getEndereco());
		listCertidaoBeanParaSalvar = CartorioController.getListSelecionados(cartorioBeanEdit.getIdCartorio());
		
	}
	
	private void cadastrar() throws Exception {
		CartorioBean cartorio = CartorioController.cadastrar(this);
		listCartorioBean = CartorioController.listaCartorios();
		salvarVinculoCartorioCertidao(cartorio.getIdCartorio(), listCertidaoBeanParaSalvar);
		new ModelMapper().map(new CartorioBean(),this);
		FacesMessage message = new FacesMessage("Cadastrado com sucesso!!");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
	}
	
	private void salvarVinculoCartorioCertidao(Integer idCartorio, List<Integer> listCertidoes) throws Exception {
		List<CartorioCertidaoBean> listCartorioCertidaoBean = new ArrayList<CartorioCertidaoBean>();
		for(Integer id : listCertidoes) {
			listCartorioCertidaoBean.add(new CartorioCertidaoBean(null,idCartorio,id));
		}
		CartorioController.salvarVinculoCartorioCertidao(idCartorio,listCartorioCertidaoBean);
		listCertidaoBeanParaSalvar = new ArrayList<Integer>();
	}
	
	private void getInfosCartorio(Integer idCartorio) throws Exception {
		cartorioBeanEdit = CartorioController.getByIdCartorio(idCartorio);
	}
	
	public void setForUpdate(CartorioBean cartorioBean) throws Exception{
		getInfosCartorio(cartorioBean.getIdCartorio());
		new ModelMapper().map(cartorioBeanEdit,this);
	}
}
