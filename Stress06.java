package stress_check;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class Stress06 extends JFrame implements ActionListener{
	//ボタンイベント処理のためimplements ActionListener追加
		//フィールドがあればここに入れる（プログラムの状態の値等）
		//ここで宣言すれば下記のスレッド等でそのまま使える
		int[] ga_num = new int[5];//質問の回答を入れる配列
		int gv_stage = 0;//現在何番目の画面か（質問等）
		  JLabel label1= new JLabel("");//文字表示に使う、はじめ
		  JLabel label2= new JLabel("");//文字表示に使う、問題中、注意	
		  JLabel label2b= new JLabel("");//文字表示に使う、問題中、問題文			  
		  JLabel label3= new JLabel("");//文字表示に使う、問題終了		  
		    JPanel p1 = new JPanel();
		    JPanel p2 = new JPanel();
		    JPanel p3 = new JPanel();
		    
		    ButtonGroup bgroup = new ButtonGroup();
		  //JPanel p1;
		  //JPanel p2;
	  public static void main(String args[]){//javaはmainメソッドから始まる
		  Stress06 frame = new Stress06("MyTitle");//クラスStress2のインスタンスframeを作成
		  //本当はframeではなくメソッドStress2の先頭を小文字にしいたstress2とするのが正しいルール
	    frame.setVisible(true);
	  }

	  Stress06(String title){
		//フレームの初期設定
	    setTitle(title);//コンストラクタかも
	    setBounds(100, 100, 600, 400);//ウィンドウのデスクトップ上の表示座標、ウィンドウのサイズ
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //ボタン操作、のメッセージ表示用
//	    label = new JLabel("");
//	    label.setHorizontalAlignment(JLabel.CENTER);
//	    label.setLayout(null);
//	    label.setBounds(20, 10, 180, 40);
    
	    
	    //始める、ボタンの配列用に追加
	    JButton button_start = new JButton("始める");
	    button_start.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 16));
	    button_start.addActionListener(this);
	    button_start.setActionCommand("始める");

	    
	    //次へ、ボタンの配列用に追加
	    JButton button_next = new JButton("次へ");
	    button_next.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 16));
	    button_next.addActionListener(this);
	    button_next.setActionCommand("次へ");
	    //戻る、ボタンの配列用に追加   
/*	    JButton button_back = new JButton("戻る");
	    button_back.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 16));
	    button_back.addActionListener(this);
	    button_back.setActionCommand("戻る");	    
*/	    //終わる、ボタンの配列用に追加   
	    JButton button_end = new JButton("終わる");
	    button_end.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 16));
	    button_end.addActionListener(this);
	    button_end.setActionCommand("終わる");	    
	    //ラジオボタン設定	    
	    JRadioButton[] radio = new JRadioButton[4]; 


	    radio[0] = new JRadioButton("そうだ");
	    radio[0].addActionListener(this);
	    radio[0].setActionCommand("1");	 
	    
	    radio[1] = new JRadioButton("まあそうだ");
	    radio[1].addActionListener(this);
	    radio[1].setActionCommand("2");	 	    
	    
	    radio[2] = new JRadioButton("ややちがう");
	    radio[2].addActionListener(this);
	    radio[2].setActionCommand("3");	 	    
	    
	    radio[3] = new JRadioButton("ちがう");	    
	    radio[3].addActionListener(this);
	    radio[3].setActionCommand("4");	 
	    //ラジオボタングループ化
//	    ButtonGroup bgroup = new ButtonGroup();
	    bgroup.add(radio[0]);
	    bgroup.add(radio[1]);
	    bgroup.add(radio[2]);
	    bgroup.add(radio[3]);

	    
	    //パネルp1をを用意
	//    JPanel p1 = new JPanel();
        //p1.setLayout(null);//ラジオボタン位置用にこれを追加
        
        p1.add(button_start); 
        //button_next.setBounds(600-80-20, 180, 80, 40);	
        p1.add(label1);
	      label1.setText("ストレスチェック開始");
	      
	    Container contentPane1 = getContentPane();
	    contentPane1.add(p1, BorderLayout.EAST); //EASTだとCENTERとあまり重ならず表示可能
		//p1.setVisible(false);
	    
	    //パネルp2をを用意
 //  JPanel p2 = new JPanel();
        p2.setLayout(null);//ラジオボタン位置用にこれを追加
        
//        p2.add(button_back);
        p2.add(button_next);
//        button_back.setBounds(20, 180, 80, 40);	
        button_next.setBounds(600-80-20-20, 180, 80, 40);	
        p2.add(label2);    
        	    label2.setBounds(50, 60, 180, 120);	    //進行表示
	    
        p2.add(label2b);    
        	    label2b.setBounds(150, 20, 380, 120);	    //問題等表示
        	    
        	    
	    
	    for (int i = 0; i < 4; i++){	//ラジオボタン    
	    	  p2.add(radio[i]);
	    	  radio[i].setBounds(100+100*i, 310, 90+10, 30);
	    }


	    
	    
	    Container contentPane2 = getContentPane(); 
	    contentPane2.add(p2, BorderLayout.CENTER);//コンポーネントの配置、これがないとボタン表示なし
		p2.setVisible(false);
		
		
	    //パネルp3をを用意
	//    JPanel p1 = new JPanel();
        //p1.setLayout(null);//ラジオボタン位置用にこれを追加
        
        p3.add(button_end); 
        //button_next.setBounds(600-80-20, 180, 80, 40);	
        p3.add(label3);
        
	    Container contentPane3 = getContentPane();
	    contentPane3.add(p3, BorderLayout.NORTH); //EASTだとCENTERとあまり重ならず表示可能
	    p3.setOpaque(false);//透明にする
		p3.setVisible(false);
	  }//Stress04

//@Override //自動で作られた、なくてもコンパイルはOK
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	    String cmd = e.getActionCommand();
//	    int run = 1;
//	  while(run)  {
	    if (cmd.equals("始める")){

	    	gv_stage=1;//実際はgv_stageのはず

	    	p1.setVisible(false);
			p2.setVisible(true);
    		label2b.setText("<html><body>これは質問"+gv_stage+"です<br>回答を選択してください</body></html>");

			//setVisible(true);
		  //    label.setText("radio1が押されました"+"ra"+ga_num[0]);  
	    }
	    if (cmd.equals("次へ")){
	    	
	    	if (ga_num[gv_stage] == 0) {
	    		label2b.setText("<html><body>これは質問"+gv_stage+"です<br>回答を選択してください</body></html>");
	    		
	    		label2.setText("<html><body>回答が選択されていません<br>回答を選択してください</body></html>");
	    		return;
	    	}
	    	
	    	gv_stage++;
	    	

	    		    bgroup.clearSelection();//ラジオボタンを全解除

	    	if (gv_stage == 5) {
	    		gv_stage = 4;
	    		}    	
	    		label2b.setText("<html><body>これは質問"+gv_stage+"です<br>回答を選択してください</body></html>");
	    	
	    		label2.setText("<html><body>次へが<br>押されました</body></html>"+gv_stage+"ra"+ga_num[gv_stage]);
//		      label2.setText("次へが押されました"+gv_stage+"ra"+ga_num[gv_stage]+
//		    		  "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		      

		      
	    }
/*	    if (cmd.equals("戻る")){//ステージ番号が1以上であるようにする
	    	gv_stage--;
	    	if (gv_stage == 0) {
	    		gv_stage = 1;
	    		}
		      label2.setText("戻るが押されました"+gv_stage+"ra"+ga_num[gv_stage]);  
	    }
*/
	    if (cmd.equals("1")){
	    	ga_num[gv_stage]=1;//実際はgv_stageのはず
		      label2.setText("radio1が押されました"+"ra"+ga_num[gv_stage]);  
	    }
	    if (cmd.equals("2")){
	    	ga_num[gv_stage]=2;//実際はgv_stageのはず
		      label2.setText("radio2が押されました"+"ra"+ga_num[gv_stage]);  
	    }
	    if (cmd.equals("3")){
	    	ga_num[gv_stage]=3;//実際はgv_stageのはず
		      label2.setText("radio3が押されました"+"ra"+ga_num[gv_stage]);  
	    }
	    if (cmd.equals("4")){
	    	ga_num[gv_stage]=4;//実際はgv_stageのはず
		      label2.setText("radio4が押されました"+"ra"+ga_num[gv_stage]);  
	    }

	    
	    
	    
	    
	    if (cmd.equals("終わる")){//ステージ番号が1以上であるようにする

/*	    	
	    	
	    	
		      label3.setText("終わるが押されました"+gv_stage+"ra"+ga_num[4]);
		        try {
		            Thread.sleep(3 * 1000);
		        }catch (InterruptedException e2) {
		            e2.printStackTrace();
		        }
*/		      System.exit(0);
		      //配列は5個なのでga_num[5]になるとエラー     
	    }
	      if(gv_stage == 4) {//次へを押して、質問が尽きた場合
		    	p2.setVisible(false);
				p3.setVisible(true);
				gv_stage++;
				

	    		label3.setText("<html><body>回答は1:"+ga_num[1]+"<br>回答は2:"+ga_num[2]+"<br>回答は3:"+ga_num[3]+"<br></body></html>");			
						
			   
	      }
//	  }//while run=1
	}//public void actionPerformed(ActionEvent e) 
	
	
	public void closepanel(JPanel aaa) {
	  aaa.setVisible(false);
	}//close panel()
	  
	}

