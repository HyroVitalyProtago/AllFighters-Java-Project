FImage = class(Rectangle)

function FImage:init(x, y, img)
    self.texture = img
    
    self.img = mesh()
    self.img:addRect(0,0,img.width,img.height)
    self.img.texture = self.texture
    
    --self.img.shader = shader("Filters:Radial Blur")
    
    Rectangle.init(self, x, y, img.width, img.height)
    self.boxs = {}
end

function FImage:addBox(box)
    table.insert(self.boxs, box)
end

function FImage:setBoxs(boxs)
    self.boxs = boxs
end

function FImage:reverse(spr)
    local img = image(self.width, self.height)
    for i=1, self.height-1 do
        for j=1, self.width-1 do
            local r,g,b,a = self.img.texture:get(self.width - j, i)
            img:set(j, i, color(r,g,b,a))
        end
    end
    local p = vec2(spr.width - self.width - self.x, self.y)
    local boxs = {}
    for i,box in ipairs(self.boxs) do
        local tmp = Box(box.type, box)
        tmp.x = self.width - box.width - box.x
        table.insert(boxs, tmp)
    end
    local fimg = FImage(p.x, p.y, img)
    fimg:setBoxs(boxs)
    
    return fimg
end

function FImage:clone()
    local fimg = FImage(self.x, self.y, self.texture)
    fimg:setBoxs(self.boxs)
    return fimg
end

function FImage:fight(fighter, fimg)
    for k,box in pairs(self.boxs) do
        tmp = box:clone()
        tmp.x = self.x + tmp.x
        tmp.y = self.y + tmp.y
        
        if (tmp.type == Box.type.ATTACKING and not box:contains(fighter)) then
            for k1, box1 in pairs(fimg.boxs) do
                box1 = box1:clone()
                box1.x = fimg.x + box1.x
                box1.y = fimg.y + box1.y
                if (box1.type == Box.type.HITTABLE and tmp:intersects(box1)) then
                    box:addFighter(fighter)
                    return true
                end
            end
        end
    end
    return false
end

function FImage:resetBoxs()
    for k,box in pairs(self.boxs) do
        box:resetFighters()
    end
end

-- DRAW
function FImage:drawBounds()
    stroke(255, 255, 255, 255) -- WHITE
    rect(0, 0, self.width, self.height)
end

function FImage:drawBoxs()
    for k,box in pairs(self.boxs) do
        box:draw()
    end
end

function FImage:draw()
    
    pushMatrix()
    translate(self.x, self.y)
    
    if (SHOW_BOXS_FIGHTER) then
        fill(255, 255, 255, 255)
        fontSize(15)
        text(self.x, -45, self.height + 20)
        text(self.y, -15, self.height + 20)
        text(self.width, 15, self.height + 20)
        text(self.height, 45, self.height + 20)
        noFill()
        self:drawBounds()
        self:drawBoxs()
    end
    
    -- Riple
    --self.img.shader.time = ElapsedTime
    --self.img.shader.freq = 0.2
    
    -- Radial blur
    --self.img.shader.sampleDist = 0.8
    --self.img.shader.sampleStrength = 1.5
    
    --sprite(self.img, 0, 0)
    
    translate(self.width/2, self.height/2 - 2)
    self.img:draw()
    
    popMatrix()
end


