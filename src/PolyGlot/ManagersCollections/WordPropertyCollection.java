/*
 * Copyright (c) 2016, Draque
 * All rights reserved.
 *
 * Licensed under: Creative Commons Attribution-NonCommercial 4.0 International Public License
 *  See LICENSE.TXT included with this code to read the full license agreement.

 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package PolyGlot.ManagersCollections;

import PolyGlot.Nodes.WordProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Draque
 */
public class WordPropertyCollection extends DictionaryCollection {
    
    public Iterator<WordProperty> getAllWordProperties() {
        List<WordProperty> retList = new ArrayList<>(nodeMap.values());

        Collections.sort(retList);

        return retList.iterator();
    }
    
    @Override
    public void clear() {
        bufferNode = new WordProperty();
    }
    
}