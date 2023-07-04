
package com.example.room

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.DialogFragment

data class Room(val name: String, val description: String)
data class Chao(val name: String)

class MapaEscola : AppCompatActivity() {

    // Primeiro piso
    private lateinit var room1: Room
    private lateinit var room2: Room
    private lateinit var room3: Room
    private lateinit var room4: Room
    private lateinit var room5: Room
    private lateinit var room6: Room
    private lateinit var room7: Room
    private lateinit var room8: Room
    private lateinit var room1WC: Room
    private lateinit var room11: Room
    private lateinit var roomWC:Room
    private lateinit var roomEscadas:Room
    private lateinit var roomSala1:Room
    private lateinit var roomSala2:Room
    private lateinit var roomGAC:Room
    private lateinit var roomBalcao:Room
    private lateinit var roomEscadas2:Room


    // Segundo Piso

    private lateinit var room9: Room
    private lateinit var room10: Room
    private lateinit var roomWC22:Room
    private lateinit var roomEscadas22:Room
    private lateinit var roomSala21:Room
    private lateinit var roomSala22:Room
    private lateinit var roomSala23:Room
    private lateinit var roomSala24:Room
    private lateinit var roomSala25:Room
    private lateinit var roomWc21:Room
    private lateinit var roomEscadas23:Room
    private lateinit var roomSala26:Room



    //piso 3
    private lateinit var roomSala31:Room
    private lateinit var roomSala32:Room
    private lateinit var roomSala33:Room
    private lateinit var roomSala34:Room
    private lateinit var roomSala35:Room
    private lateinit var roomSala36:Room
    private lateinit var roomSala37:Room
    private lateinit var roomSala38:Room
    private lateinit var roomSalaReuniao:Room
    private lateinit var roomGab1:Room
    private lateinit var roomGab2:Room
    private lateinit var roomGab3:Room
    private lateinit var roomGab4:Room
    private lateinit var roomGab5:Room
    private lateinit var roomDirecao:Room
    private lateinit var roomEscadas31:Room
    private lateinit var roomWc31:Room
    private lateinit var roomWc32:Room
    private lateinit var roomWc3:Room
    private lateinit var roomEscadas32:Room


    //Biblioteca
    private lateinit var roomSalaB1:Room
    private lateinit var roomSalaB2:Room
    private lateinit var roomSalaB3:Room
    private lateinit var roomSalaB4:Room
    private lateinit var roomEscadasB:Room




    //Chao

    private lateinit var chaoEntrada: Chao
    private lateinit var chaoEntradaLateral: Chao
    private lateinit var chaoEntradaTras: Chao
    private lateinit var chaoEntradaLEscadas: Chao
    private lateinit var chaoCantina: Chao
    private lateinit var chaoAuditorio:Chao
    private lateinit var chaoAuditorio2:Chao
    private lateinit var chaoFundo:Chao
    //2 piso
    private lateinit var chaoPrinciapal:Chao
    private lateinit var chaoLateral:Chao
    private lateinit var chaoEscWc:Chao
    //3 piso
    private lateinit var chaoLateral1:Chao
    private lateinit var chaoGrande:Chao
    private lateinit var chaoLateral3:Chao
    //Biblioteca
    private lateinit var chaoLateralB:Chao
    private lateinit var chaoGrandeB:Chao

    //----------------------------------------//

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navDrawer: LinearLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plantaescola)

        drawerLayout = findViewById(R.id.drawer_layout)
        navDrawer = findViewById(R.id.nav_drawer)

        val openMenuButton: ImageButton = findViewById(R.id.button_open_menu)
        openMenuButton.setOnClickListener {
            drawerLayout.openDrawer(navDrawer)
        }

        // Chao piso 1

        chaoEntrada = Chao("chao1")
        chaoEntradaLateral = Chao("chao2")
        chaoEntradaTras = Chao("chao3")
        chaoEntradaLEscadas = Chao ("chao4")
        chaoCantina = Chao("chao5")
        chaoAuditorio = Chao("chao5")
        chaoAuditorio2 = Chao("chao6")
        chaoFundo = Chao("chao7")

        //chao piso 2
        chaoPrinciapal= Chao("chao8")
        chaoLateral = Chao("chao9")
        chaoEscWc = Chao ("chao 10")

        //chao piso 3
        chaoLateral1 = Chao ("chao 11")
        chaoGrande = Chao ("chao 12")
        chaoLateral3 = Chao ("chao 13")


        // chao Biblioteca
        chaoLateralB = Chao ("chao 14")
        chaoGrandeB = Chao ("chao 15")






        //Piso 1

        room1 = Room("Cantina", "Esta é a cantina da escola")
        room2 = Room("Entrada Principal", "Esta é a entrada principal da escola")
        room3 = Room("Bar", "Este é o bar da escola onde podes lanchar")
        room4 = Room("Segurança", "Ajuda a encontrar qualquer sala")
        room5 = Room("Escadas", "Estas escadas dão acesso ao piso 2")
        room6 = Room("Entrada Cantina", "Esta é uma entrada lateral da escola")
        room7 = Room("Entrada Traseiras", "Esta é uma entrada na parte de trás da escola, dá acesso à biblioteca")
        room8 = Room(" Serviços Académicos", "Quando tiveres algum problema vem aqui!")
        room11= Room(" Auditório", "Auditório da ESTG")
        roomWC= Room("Wc", "")
        roomEscadas=Room("Escadas", "Estas escadas dão acesso ao 3 piso")
        room1WC = Room("WC", "Casa de banho")
        roomSala1 = Room("Sala 1.1", "")
        roomSala2 = Room("Sala 1.2", "")
        roomGAC = Room("GAC", "GAC, Gabinete de Apoio a Cursos ")
        roomBalcao=Room("Balcão Único", "")
        roomEscadas2=Room("escadas","")


        //Piso 2

        room9 = Room("Reprografia", "Aqui podes tirar cópia dos teus documentos, comprar materiais etc")
        room10 = Room("Espaço de convivio", "Aqui podes estudar, fazer trabalhos de grupo, etc")
        roomWC22= Room("WC","")
        roomEscadas22= Room("Escadas", "")
        roomSala21=Room("Sala 2.1", "")
        roomSala22=Room("Sala 2.2", "")
        roomSala23=Room("Sala 2.3", "")
        roomSala24=Room("Sala 2.4", "")
        roomSala25=Room("Sala 2.5", "")
        roomSala26=Room("Sala 2.6", "")
        roomWc21=Room ("WC", "")
        roomEscadas23 = Room("Escadas", "")

        //Piso 3

        roomSala31=Room("Sala 3.1", "")
        roomSala32=Room("Sala 3.2", "")
        roomSala33=Room("Sala 3.3", "")
        roomSala34=Room("Sala 3.4", "")
        roomSala35=Room("Sala 3.5", "")
        roomSala36=Room("Sala 3.6", "")
        roomSala37=Room("Sala 3.7", "")
        roomSala38=Room("Sala 3.8", "")
        roomSalaReuniao =Room("Sala Reunião", "Nesta sala podes estudar ou fazer trabalhos de grupo")
        roomGab1 = Room("Gab.1","Cada professor tem um gabinete onde podes tirar dúvidas nos seus horários de atendimento")
        roomGab2 = Room("Gab.2","Cada professor tem um gabinete onde podes tirar dúvidas nos seus horários de atendimento")
        roomGab3 = Room("Gab.3","Cada professor tem um gabinete onde podes tirar dúvidas nos seus horários de atendimento")
        roomGab4 = Room("Gab.4","Cada professor tem um gabinete onde podes tirar dúvidas nos seus horários de atendimento")
        roomGab5 = Room("Gab.5","Cada professor tem um gabinete onde podes tirar dúvidas nos seus horários de atendimento")
        roomDirecao=Room("Direção", "Direção da ESTG")
        roomEscadas31= Room("Escadas", "")
        roomWc31 = Room("WC", "")
        roomWc32 = Room ("WC", "")
        roomWc3 = Room("WC", "")
        roomEscadas32 = Room("Escadas","")


        //Biblioteca

         roomSalaB1=Room ("Sala de Estudo 1", "")
         roomSalaB2=Room ("Sala de Estudo 2", "")
         roomSalaB3=Room ("Sala de Estudo 3", "")
         roomSalaB4=Room ("Sala de Estudo 4", "")
         roomEscadasB=Room ("Escadas", "")









        //------------------------------------------------------------------------------------//

        val floorSpinner = findViewById<Spinner>(R.id.floorSpinner)
        val floors = arrayOf("Piso 1", "Piso 2", "Piso 3", "Biblioteca") // Adicione os pisos desejados aqui
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, floors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        floorSpinner.adapter = adapter

        floorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Lógica para atualizar o layout das salas de acordo com o piso selecionado
                updateRoomsLayout(position + 1) // +1 porque os índices do array começam em 0
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Nada a fazer aqui
            }
        }

        // Recuperar o valor do piso da sala passado pela atividade InfoSalaEstudo
        val pisoSala = intent.getIntExtra("pisoSala", 1)

        // Selecionar automaticamente o piso correspondente
        val floorIndex = pisoSala - 1
        floorSpinner.setSelection(floorIndex)




    }

    private fun updateRoomsLayout(floor: Int) {
        val layout = findViewById<RelativeLayout>(R.id.roomsLayout)
        layout.removeAllViews() // Limpa as visualizações anteriores

        // Lógica para adicionar as salas do piso selecionado ao layout
        when (floor) {
            1 -> {
                createRoomView(room1, 20, 100, 800, 400, Color.rgb(60,139,242)) //cantina
                createRoomView(room2, 100, 1090, 400, 200, Color.rgb(43,161,75))//entrada Principal
                createRoomView(room3, 1200, 700, 500, 300, Color.rgb(60,109,173))//bar
                createRoomView(room4, 330, 1700, 250, 180, Color.GRAY)//segurança
                createRoomView(room5, 1200, 500, 300, 100, Color.rgb(186,116,24))//escadas cantina
                createRoomView(room6, 850, 150, 480, 100, Color.rgb(43,161,75))//entrada Cantina
                createRoomView(room7, 1450, 1090, 400, 200, Color.rgb(43,161,75))//entrada Traseiras
                createRoomView(room8, 600, 1700, 390, 400, Color.rgb(255,34,34))//académicos
                createRoomView(room11,100,2010,450,200,Color.rgb(255,106,34))//auditorio
                createRoomView(room1WC,1350,210,300,100,Color.BLUE)//WC
                createRoomView(roomWC,1000,1400,300,100,Color.BLUE)//WC
                createRoomView(roomEscadas, 1100, 1600, 300, 100, Color.rgb(186,116,24))//escadas
                createRoomView(roomSala1, 1400, 1300, 300, 200, Color.rgb(222,222,222) )//sala 1
                createRoomView(roomSala2,1750,1300,300,200,Color.rgb(222,222,222))//sala2
                createRoomView(roomGAC,1050,2150,300,300,Color.rgb(255,34,34))//GAC
                createRoomView(roomBalcao,1050,1800,300,300,Color.rgb(255,34,34)) //Balcao
                createRoomView(roomEscadas2,600,2650,300,100,Color.rgb(186,116,24))


                createChaoView(chaoEntrada, 510, 1100, 500, 100)
                createChaoView(chaoEntradaLateral, 950, 300, 100, 2300)
                createChaoView(chaoEntradaTras, 1000, 1111, 400, 100)
                createChaoView(chaoEntradaLEscadas, 1000, 350, 900, 100)
                createChaoView(chaoCantina, 100, 600, 900, 100)
                createChaoView(chaoAuditorio,300,1500,1600,100)
                createChaoView(chaoAuditorio2, 220,1500,80,500)
                createChaoView(chaoFundo,600,2570,800,80)
            }
            2 -> {
                createRoomView(room9, 500, 1700, 400, 400, Color.rgb(255,34,34)) //reprografia
                createRoomView(room10, 1100, 1500, 500, 600, Color.GRAY) // espaço em frente à papelaria
                createRoomView(roomWC22,1350,210,300,100,Color.BLUE)//WC
                createRoomView(roomEscadas22,1200, 500, 300, 100, Color.rgb(186,116,24))
                createRoomView(roomSala21,1750,210,300,100,Color.rgb(222,222,222))
                createRoomView(roomSala22,1750,510,300,100,Color.rgb(222,222,222))
                createRoomView(roomSala23,2090,510,300,100,Color.rgb(222,222,222))
                createRoomView(roomSala24,600,500,300, 100, Color.rgb(222,222,222))
                createRoomView(roomSala25,600,700,300, 100, Color.rgb(222,222,222))
                createRoomView(roomSala26,1600,2200,300, 100, Color.rgb(222,222,222))
                createRoomView(roomEscadas23,1200,2500,300, 100, Color.rgb(186,116,24))
                createRoomView(roomWc21,1200,2200,300, 100, Color.BLUE)



                createChaoView(chaoPrinciapal,950,300,100,2500)
                createChaoView(chaoLateral, 1000, 350, 1600, 100)
                createChaoView(chaoEscWc,1000, 2350,1000, 100)

            }
            3 -> {
                createRoomView(roomSala31,100,1100,300, 100, Color.rgb(222,222,222))
               createRoomView(roomSala32,100,900,300, 100, Color.rgb(222,222,222))
               createRoomView(roomSala33,100,700,300, 100, Color.rgb(222,222,222))
                createRoomView(roomSala34,100,500,300, 100, Color.rgb(222,222,222))
               createRoomView(roomDirecao,400, 150, 350, 200,Color.rgb(255,34,34))
               createRoomView(roomEscadas31,900,450,300, 100, Color.rgb(186,116,24))
                createRoomView(roomWc31,900,250,350,100, Color.BLUE)
                createRoomView(roomSala35,500,600,300,100, Color.rgb(222,222,222))
                createRoomView(roomSala36,500,800,300,100, Color.rgb(222,222,222))
                createRoomView(roomGab1,900,1200,200,200,Color.rgb(255,106,34))
                createRoomView(roomGab2,1200,1200,200,200,Color.rgb(255,106,34))
                createRoomView(roomGab3,1500,1200,200,200,Color.rgb(255,106,34))
                createRoomView(roomGab4,1800,1200,200,200,Color.rgb(255,106,34))
                createRoomView(roomGab5,2100,1200,200,200,Color.rgb(255,106,34))
                createRoomView(roomSala37,500,1500,300, 100, Color.rgb(222,222,222))
                createRoomView(roomSala38,900,1500,300, 100, Color.rgb(222,222,222))
                createRoomView(roomSalaReuniao,500,1200,300,200,Color.rgb(43,161,75))
                createRoomView(roomWc3,100,1300,350,100, Color.BLUE)
                createRoomView(roomEscadas32, 100,1500,300, 100, Color.rgb(186,116,24))








                createChaoView(chaoLateral1,400, 350,1000, 100)
                createChaoView(chaoGrande,400, 350,100, 1100)
                createChaoView(chaoLateral3,50,1400,2400,100)
                // ...
            }

            4 -> {
               createRoomView(roomSalaB1,10,1100,400, 100, Color.rgb(43,161,75))
                createRoomView(roomSalaB2,10,1400,400, 100, Color.rgb(43,161,75))
                createRoomView(roomSalaB3,500,1100,400, 100, Color.rgb(43,161,75))
                createRoomView(roomSalaB4,500,1400,400, 100, Color.rgb(43,161,75))
                createRoomView(roomEscadasB, 700,350,300, 100, Color.rgb(186,116,24))

                /*

                roomEscadasB=Room ("Escadas", "")*/



                createChaoView( chaoLateralB, 400,350,300, 100)
                createChaoView(chaoGrandeB,400,350,100,1300)

            }

            // Adicione outros casos para pisos adicionais, se necessário
        }

    }

    private fun createChaoView(parede1: Chao,leftMargin: Int, topMargin: Int, width: Int, height: Int) {

        val context: Context = this
        val layout = findViewById<RelativeLayout>(R.id.roomsLayout)

        val paredeView = LayoutInflater.from(context).inflate(R.layout.parede, layout, false)


        val layoutParams = ViewGroup.MarginLayoutParams(width, height)
        ViewGroup.MarginLayoutParams.WRAP_CONTENT
        ViewGroup.MarginLayoutParams.WRAP_CONTENT
        layoutParams.leftMargin = leftMargin
        layoutParams.topMargin = topMargin

        paredeView.layoutParams = layoutParams

        layout.addView(paredeView)


    }


    private fun createRoomView(room: Room, leftMargin: Int, topMargin: Int, width: Int, height: Int,color: Int) {
        val context: Context = this
        val layout = findViewById<RelativeLayout>(R.id.roomsLayout)

        val roomView = LayoutInflater.from(context).inflate(R.layout.item_room, layout, false)
        val roomNameTextView = roomView.findViewById<TextView>(R.id.tvRoomName)


        roomNameTextView.text = room.name


        val layoutParams = ViewGroup.MarginLayoutParams(width, height)
        ViewGroup.MarginLayoutParams.WRAP_CONTENT
        ViewGroup.MarginLayoutParams.WRAP_CONTENT
        layoutParams.leftMargin = leftMargin
        layoutParams.topMargin = topMargin

        roomView.layoutParams = layoutParams
        roomView.setBackgroundColor(color)

        roomView.setOnClickListener {
            val roomInfoDialog = RoomInfoDialog.newInstance(room)
            roomInfoDialog.show(supportFragmentManager, "room_info")
        }

        layout.addView(roomView)
    }



    fun abrePaginaInicial(view: View) {
        //remover o toast
        //Toast.makeText(applicationContext, "Abre Página Inicial", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun abreBiblioteca(view: View) {
        //remover o toast
        //Toast.makeText(applicationContext, "Abre Biblioteca", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, Lugares_Biblioteca::class.java)
        startActivity(intent)
    }

    fun abreSalaEstudo(view: View) {
        //remover o toast
        //Toast.makeText(applicationContext, "Abre Salas de Estudo", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, ListarSalas::class.java)
        startActivity(intent)
        //criar  SalasEstudo para isto funcionar
        /*val intent = Intent(this, SalasEstudo::class.java)
        startActivity(intent)*/
    }
    fun abreMapa(view: View) {
        //remover o toast
        val intent = Intent(this, MapaEscola::class.java)
        startActivity(intent)
    }
    fun abreLogout(view: View) {
        //remover o toast
        val sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.remove("username")
        editor.apply()

        val intent = Intent(this, Login::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    fun abreLocalizacao(view: View) {

        val intent = Intent(this, LocalizaUser::class.java)
        startActivity(intent)
    }

}

class RoomInfoDialog(private val room: Room) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val context = requireContext()
        val dialogView = layoutInflater.inflate(R.layout.dialog_room_info, null)
        val roomNameTextView = dialogView.findViewById<TextView>(R.id.tvRoomName)
        val roomDescriptionTextView = dialogView.findViewById<TextView>(R.id.tvRoomDescription)

        roomNameTextView.text = room.name
        roomDescriptionTextView.text = room.description

        return AlertDialog.Builder(context)
            .setView(dialogView)
            .create()
    }

    companion object {
        fun newInstance(room: Room): RoomInfoDialog {
            return RoomInfoDialog(room)
        }
    }
}
