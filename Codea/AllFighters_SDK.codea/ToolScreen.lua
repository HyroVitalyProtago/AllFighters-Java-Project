ToolScreen = class()

function ToolScreen.makeCustomBackground(screen)
    local spr = image(WIDTH, HEIGHT)
    setContext(spr)
        local gray = 230
        fill(gray, gray, gray)
        noStroke()
        rect(0, 0, spr.width, spr.height)
    setContext()
    
    screen.customBackground = Mesh.makeMesh(spr, {})
    screen.customBackground.pos.x = WIDTH/2
    screen.customBackground.pos.y = HEIGHT/2
    screen.customBackground.pos.z = 3
    table.insert(screen.meshes, screen.customBackground)
end

function ToolScreen.makeMenuTop(screen)
    local spr = image(WIDTH, 50)
    setContext(spr)
        local gray = 22
        fill(gray, gray, gray)
        strokeWidth(2)
        stroke(0, 0, 0)
        rect(0, 0, spr.width, spr.height)
    setContext()
    
    screen.menuTop = Mesh.makeMesh(spr, {})
    screen.menuTop.pos.x = WIDTH/2
    screen.menuTop.pos.y = HEIGHT-spr.height/2
    screen.menuTop.pos.z = 5
    table.insert(screen.meshes, screen.menuTop)
end

function ToolScreen.makeCurrentLocation(screen, txt)
    screen.currentLocation = Mesh.makeTextMesh(txt,{
        fill=color(255,255,255,255), 
        fontSize=20, 
        textWrapWidth=WIDTH/1.1, 
        textAlign=CENTER,
        font="Helvetica-Light"
    })
    screen.currentLocation.pos.x = WIDTH/2
    screen.currentLocation.pos.y = HEIGHT - screen.currentLocation.dim.h - 3
    screen.currentLocation.pos.z = 10
    table.insert(screen.meshes, screen.currentLocation)
end

function ToolScreen.makeInfos(screen)
    local spr = readImage("Dropbox:SpriteAllFighters/SDK/info")
    local _x = 0.7
    screen.infos = Mesh.makeMesh(spr,{
        width=spr.width*_x,
        height=spr.height*_x
    })
    screen.infos.pos.x = WIDTH - screen.infos.dim.w
    screen.infos.pos.y = HEIGHT - screen.infos.dim.h + 5 
    screen.infos.pos.z = 10
    table.insert(screen.meshes, screen.infos)
end

function ToolScreen.makePrevious(screen)
    local spr = image(50, HEIGHT-50)
    setContext(spr)
        local gray = 39
        fill(gray, gray, gray, 50)
        noStroke()
        rect(0, 0, spr.width, spr.height)
        local spr2 = readImage("Dropbox:SpriteAllFighters/SDK/previous")
        sprite(spr2, spr2.width/4 - 3, spr.height/2, spr2.width*0.4, spr2.height*0.4)
    setContext()
    
    screen.previous = Mesh.makeMesh(spr, {})
    screen.previous.pos.x = spr.width/2
    screen.previous.pos.y = HEIGHT/2 - 25
    screen.previous.pos.z = -5
    table.insert(screen.meshes, screen.previous)
end

function ToolScreen.makeNext(screen)
    local spr = image(50, HEIGHT-50)
    setContext(spr)
        local gray = 39
        fill(gray, gray, gray, 50)
        noStroke()
        rect(0, 0, spr.width, spr.height)
        local spr2 = readImage("Dropbox:SpriteAllFighters/SDK/next")
        sprite(spr2, spr2.width/4 - 10, spr.height/2, spr2.width*0.4, spr2.height*0.4)
    setContext()
    
    screen.next = Mesh.makeMesh(spr, {})
    screen.next.pos.x = WIDTH - spr.width/2
    screen.next.pos.y = HEIGHT/2 - 25
    screen.next.pos.z = -5
    table.insert(screen.meshes, screen.next)
end